class Dummy{
public void doPost(HttpServletRequest request, HttpServletResponse response) {
    System.out.println("----- InsertCourseServlet -----");
    try {
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        String role;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = null;
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydb", "root", "root");
            for (SQLWarning warn = conn.getWarnings(); warn != null; warn = warn.getNextWarning()) {
                System.out.println("SQL Warning:");
                System.out.println("State  : " + warn.getSQLState());
                System.out.println("Message: " + warn.getMessage());
                System.out.println("Error  : " + warn.getErrorCode());
            }
            java.sql.Statement stmt = conn.createStatement();
            java.sql.Statement rs = conn.createStatement();
            int ProfIdVariable = Integer.parseInt(request.getParameter("ProfId"));
            System.out.println(83);
            ResultSet midRowCount = rs.executeQuery("Select count(m_id) as MidRows from master where prof_id = " + ProfIdVariable + ";");
            System.out.println(84);
            midRowCount.first();
            System.out.println(85);
            int midRows = midRowCount.getInt("MidRows");
            int[] mids = new int[midRows];
            int[] courses = new int[midRows];
            int count = 0;
            ResultSet midList = rs.executeQuery("Select m_id from master where prof_id = " + ProfIdVariable + ";");
            System.out.println(98);
            while (midList.next()) {
                mids[count] = midList.getInt("m_id");
                count += 1;
            }
            count = 0;
rs = conn.createStatement();
            ResultSet totalCourses = rs.executeQuery("Select master.references, course_id from master where prof_id = " + ProfIdVariable + ";");
            System.out.println(106);
            while (totalCourses.next()) {
                hmap.put(mids[count], totalCourses.getInt("references"));
                count += 1;
            }
            System.out.println(112);
            String MondayMidTotal = "";
            String TuesdayMidTotal = "";
            String WednesdayMidTotal = "";
            String ThursdayMidTotal = "";
            String FridayMidTotal = "";
            String[] rooms = { "fh_346", "fh_363", "fh_372", "fh_450a", "fh_451", "fh_457", "fh_460", "fh_462", "fh_463", "fh_464", "fh_535", "fh_557", "fh_560", "fh_560h" };
            for (int i = 0; i < midRows; i++) {
                if (i == 0) {
                    MondayMidTotal += "(";
                    TuesdayMidTotal += "(";
                    WednesdayMidTotal += "(";
                    ThursdayMidTotal += "(";
                    FridayMidTotal += "(";
                }
                MondayMidTotal += "Monday =" + mids[i];
                TuesdayMidTotal += "Tuesday =" + mids[i];
                WednesdayMidTotal += "Wednesday =" + mids[i];
                ThursdayMidTotal += "Thursday =" + mids[i];
                FridayMidTotal += "Friday =" + mids[i];
                if (i < midRows - 1) {
                    MondayMidTotal += " or ";
                    TuesdayMidTotal += " or ";
                    WednesdayMidTotal += " or ";
                    ThursdayMidTotal += " or ";
                    FridayMidTotal += " or ";
                } else if (i == midRows - 1) {
                    MondayMidTotal += ")";
                    TuesdayMidTotal += ")";
                    WednesdayMidTotal += ")";
                    ThursdayMidTotal += ")";
                    FridayMidTotal += ")";
                }
            }
            String weeklyMidCheck = MondayMidTotal + " or " + TuesdayMidTotal + " or " + WednesdayMidTotal + " or " + ThursdayMidTotal + " or " + FridayMidTotal;
            String ProfTimeTable = "";
            for (int j = 0; j <= 13; j++) {
                if (j < 13) {
                    ProfTimeTable += "SELECT * from " + rooms[j] + " where " + weeklyMidCheck + " UNION ";
                } else
                    ProfTimeTable += "SELECT * from " + rooms[j] + " where " + weeklyMidCheck;
            }
            System.out.println(ProfTimeTable);
            java.sql.Statement profQ = conn.createStatement();
            if (count == 0) {
                System.out.println("COUNT IS 0 " + count);
                Time defaultTime = null;
                TimeSchedule course = new TimeSchedule();
                course.setTimeBlock(defaultTime);
                course.setMonday("NONE");
                course.setTuesday("NONE");
                course.setWednesday("NONE");
                course.setThursday("NONE");
                course.setFriday("NONE");
                list.add(course);
            } else {
                System.out.println("COUNT IS NOT 0 " + count);
                ResultSet pTimes = profQ.executeQuery(ProfTimeTable);
                int monReferences = 0;
                int tuesReferences = 0;
                int wedReferences = 0;
                int thursReferences = 0;
                int friReferences = 0;
                int MondayVarMaster;
                int TuesdayVarMaster;
                int WednesdayVarMaster;
                int ThursdayVarMaster;
                int FridayVarMaster;
                String professorName;
                String courseId;
                ResultSet MonpName = null;
                ResultSet TuespName = null;
                ResultSet WedpName = null;
                ResultSet ThurspName = null;
                ResultSet FripName = null;
                String insertToMonday;
                String insertToTuesday = null;
                String insertToWednesday;
                String insertToThursday = null;
                String insertToFriday;
                while (pTimes.next()) {
                    TimeSchedule course = new TimeSchedule();
                    course.setTimeBlock(pTimes.getTime("Time"));
                    MondayVarMaster = pTimes.getInt("Monday");
                    TuesdayVarMaster = pTimes.getInt("Tuesday");
                    WednesdayVarMaster = pTimes.getInt("Wednesday");
                    ThursdayVarMaster = pTimes.getInt("Thursday");
                    FridayVarMaster = pTimes.getInt("Friday");
                    System.out.println(MondayVarMaster + "   " + 209);
                    System.out.println(hmap.get(1) + "    " + 210);
                    monReferences = hmap.get(MondayVarMaster);
                    java.sql.Statement monQ = conn.createStatement();
                    MonpName = monQ.executeQuery("SELECT master.course_id, professor.prof_name, master.references from master inner join professor on master.prof_id=professor.prof_id where master.prof_id=" + ProfIdVariable + " AND master.references = " + monReferences + ";");
                    if (MonpName.first()) {
                        professorName = MonpName.getString("prof_name");
                        courseId = MonpName.getString("course_id");
                        insertToMonday = "<b>Professor</b>: " + professorName + "<hr/> <b>Course ID</b>: " + courseId;
                    } else
                        insertToMonday = "No Class";
                    System.out.println(MondayVarMaster + "  Monday MID VAR " + monReferences);
                    System.out.println(TuesdayVarMaster + "  Tuesday MID VAR ");
                    if (hmap.containsKey(TuesdayVarMaster)) {
                        tuesReferences = hmap.get(TuesdayVarMaster);
                        java.sql.Statement tuesQ = conn.createStatement();
                        TuespName = tuesQ.executeQuery("SELECT master.course_id, professor.prof_name, master.references from master inner join professor on master.prof_id=professor.prof_id where master.prof_id=" + ProfIdVariable + " AND master.references = " + tuesReferences + ";");
                        if (TuespName.first()) {
                            professorName = TuespName.getString("prof_name");
                            courseId = TuespName.getString("course_id");
                            insertToTuesday = "<b>Professor</b>: " + professorName + "<hr/> <b>Course ID</b>: " + courseId;
                        }
                    } else
                        insertToTuesday = "No Class";
                    wedReferences = hmap.get(WednesdayVarMaster);
                    java.sql.Statement wedQ = conn.createStatement();
                    WedpName = wedQ.executeQuery("SELECT master.course_id, professor.prof_name, master.references from master inner join professor on master.prof_id=professor.prof_id where master.prof_id=" + ProfIdVariable + " AND master.references = " + wedReferences + ";");
                    if (WedpName.first()) {
                        professorName = WedpName.getString("prof_name");
                        courseId = WedpName.getString("course_id");
                        insertToWednesday = "<b>Professor</b>: " + professorName + "<hr/> <b>Course ID</b>: " + courseId;
                    } else
                        insertToWednesday = "No Class";
                    if (hmap.containsKey(ThursdayVarMaster)) {
                        thursReferences = hmap.get(ThursdayVarMaster);
                        java.sql.Statement thursQ = conn.createStatement();
                        ThurspName = thursQ.executeQuery("SELECT master.course_id, professor.prof_name, master.references from master inner join professor on master.prof_id=professor.prof_id where master.prof_id=" + ProfIdVariable + " AND master.references = " + thursReferences + ";");
                        if (ThurspName.first()) {
                            professorName = ThurspName.getString("prof_name");
                            courseId = ThurspName.getString("course_id");
                            insertToThursday = "<b>Professor</b>: " + professorName + "<hr/> <b>Course ID</b>: " + courseId;
                        }
                    } else
                        insertToThursday = "No Class";
                    friReferences = hmap.get(FridayVarMaster);
                    java.sql.Statement friQ = conn.createStatement();
                    FripName = friQ.executeQuery("SELECT master.course_id, professor.prof_name, master.references from master inner join professor on master.prof_id=professor.prof_id where master.prof_id=" + ProfIdVariable + " AND master.references = " + friReferences + ";");
                    if (FripName.first()) {
                        professorName = FripName.getString("prof_name");
                        courseId = FripName.getString("course_id");
                        insertToFriday = "<b>Professor</b>: " + professorName + "<hr/> <b>Course ID</b>: " + courseId;
                    } else
                        insertToFriday = "No Class";
                    System.out.println(course.getMonday());
                    System.out.println(course.getTuesday());
                    System.out.println(course.getWednesday());
                    System.out.println(course.getThursday());
                    System.out.println(course.getFriday());
                    course.setMonday(insertToMonday);
                    course.setTuesday(insertToTuesday);
                    course.setWednesday(insertToWednesday);
                    course.setThursday(insertToThursday);
                    course.setFriday(insertToFriday);
                    course.setRoomInfo(pTimes.getString("building_name_no"));
                    list.add(course);
                }
                rs.close();
                stmt.close();
                conn.close();
            }
        } catch (SQLException se) {
            System.out.println("SQL Exception:");
            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());
                se = se.getNextException();
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/ProfTime.jsp");
        request.setAttribute("cust", list);
        dispatcher.forward(request, response);
        list.clear();
    } catch (ServletException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    }
}}

