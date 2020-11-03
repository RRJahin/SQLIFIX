class Dummy{
public void doPost(HttpServletRequest request, HttpServletResponse response) {
    System.out.println("----- New Action Servlet -----");
    try {
        ArrayList<Course> list22 = (ArrayList<Course>) request.getAttribute("mid");
        Course c = list22.get(0);
        int m_id = c.getMid();
        System.out.println(m_id);
        String role = request.getParameter("status");
        System.out.println(role + " STATUS");
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
            java.sql.Statement update = conn.createStatement();
            java.sql.Statement courseDetails = conn.createStatement();
            java.sql.Statement professorDetails = conn.createStatement();
            java.sql.Statement pStatusQuery = conn.createStatement();
            ResultSet professorStatus;
            professorStatus = pStatusQuery.executeQuery("select master.m_id, master.prof_id, professor_status.prof_status from master inner join	professor on master.prof_id= professor.prof_id inner join professor_status on professor.status_id= professor_status.status_id WHERE m_id=" + m_id + ";");
            if (professorStatus.first()) {
                role = professorStatus.getString("prof_status");
            } else {
                System.out.append("no prof stataus ");
            }
            ResultSet rs = null;
            int totalRows = 0;
            int updateResult = 0;
            ResultSet rowRange = null;
            boolean hasData;
            boolean after3 = false;
            String selectedRoom = "";
            String[] rooms = { "fh_346", "fh_363", "fh_372", "fh_450a", "fh_451", "fh_457", "fh_460", "fh_462", "fh_463", "fh_464", "fh_535", "fh_557", "fh_560", "fh_560h" };
            int endRange = 0;
            boolean found = false;
            System.out.println(m_id + "  Master Id");
            int startRange = 0;
            int incrementBy = 0;
            int rowsInsertLength = 0;
            if (role.equals("fulltime"))
                rowsInsertLength = 4;
            else
                rowsInsertLength = 6;
            for (int i = 0; i <= 13; i++) {
                after3 = false;
                if (role.equals("fulltime"))
                    incrementBy = 4;
                else
                    incrementBy = 6;
                for (int j = 1; j <= 53; j = j + incrementBy) {
                    if (j >= 29 && role.equals("fulltime")) {
                        incrementBy = 6;
                        System.out.println(incrementBy + "   " + j + "   " + rooms[i]);
                        endRange = j + 5;
                        rowsInsertLength = 6;
                        after3 = true;
                    } else if (role.equals("fulltime")) {
                        endRange = j + 3;
                        System.out.println(incrementBy + "   " + j + "   " + rooms[i]);
                        rowsInsertLength = 4;
                        after3 = false;
                    } else
                        endRange = j + 5;
                    if (role.equals("fulltime") && !after3)
                        rowRange = update.executeQuery("(select  count(" + rooms[i] + ".id) as cnt from " + rooms[i] + "  WHERE Monday=0 AND Wednesday=0 AND Friday=0 AND id BETWEEN " + j + " AND " + endRange + " );");
                    else if (role.equals("fulltime") && after3)
                        rowRange = update.executeQuery("(select  count(" + rooms[i] + ".id) as cnt from " + rooms[i] + "  WHERE Monday=0 AND Wednesday=0 AND id BETWEEN " + j + " AND " + endRange + " );");
                    else
                        rowRange = update.executeQuery("(select  count(" + rooms[i] + ".id) as cnt from " + rooms[i] + "  WHERE Tuesday=0 AND Thursday=0 AND Friday=0 AND id BETWEEN " + j + " AND " + endRange + " );");
                    rowRange.next();
                    totalRows = rowRange.getInt("cnt");
                    if (totalRows == rowsInsertLength) {
                        System.out.println(totalRows + "  Total Rows " + rowsInsertLength + " Insertlength,   End range " + endRange + "  j " + j);
                        for (int k = j; k <= endRange; k++) {
                            if (role.equals("fulltime") && after3) {
                                updateResult = update.executeUpdate("UPDATE " + rooms[i] + " SET Monday=" + m_id + ",Wednesday=" + m_id + " WHERE id = " + k + ";");
                                System.out.println(updateResult);
update = conn.createStatement();
                            } else if (role.equals("fulltime") && !after3)
                                updateResult = update.executeUpdate("UPDATE " + rooms[i] + " SET Monday=" + m_id + ",Wednesday=" + m_id + ",Friday=" + m_id + " WHERE id = " + k + ";");
update = conn.createStatement();
                            else
update = conn.createStatement();
                                updateResult = update.executeUpdate("UPDATE " + rooms[i] + " SET Tuesday=" + m_id + ",Thursday=" + m_id + " WHERE id = " + k + ";");
                        }
                        selectedRoom = rooms[i];
                        startRange = j;
                        update.close();
                        System.out.println("YES " + rooms[i] + " " + totalRows + " " + m_id);
                        rowRange.close();
                        found = true;
                        break;
                    }
                }
                if (found)
                    break;
            }
            java.sql.Statement stmt = conn.createStatement();
            System.out.println(after3);
            if (after3 && role.equals("fulltime")) {
                rs = stmt.executeQuery("(select " + selectedRoom + ".* from " + selectedRoom + " WHERE id BETWEEN " + startRange + " AND " + endRange + ") LIMIT 6");
stmt = conn.createStatement();
                System.out.println(rs);
            } else if (!after3 && role.equals("fulltime"))
stmt = conn.createStatement();
                rs = stmt.executeQuery("(select " + selectedRoom + ".* from " + selectedRoom + " WHERE id BETWEEN " + startRange + " AND " + endRange + ") LIMIT 4");
            else
                rs = stmt.executeQuery("(select " + selectedRoom + ".* from " + selectedRoom + " WHERE id BETWEEN " + startRange + " AND " + endRange + ") LIMIT 6");
            ResultSet mondayCourse = null;
            String mondayCourseId;
            String mondayCourseName;
            int MondayVar = 0;
            String insertToMon = "";
            ResultSet tuesdayCourse = null;
            String tuesdayCourseId;
            String tuesdayCourseName;
            int TuesdayVar = 0;
            String insertToTues = "";
            ResultSet wednesdayCourse = null;
            String wednesdayCourseId;
            String wednesdayCourseName;
            int WednesdayVar = 0;
            String insertToWed = "";
            ResultSet thursdayCourse = null;
            String thursdayCourseId;
            String thursdayCourseName;
            int ThursdayVar = 0;
            String insertToThurs = "";
            ResultSet fridayCourse = null;
            String fridayCourseId;
            String fridayCourseName;
            int FridayVar = 0;
            String insertToFri = "";
            String profName;
            ResultSet MondayProfessorQuery = null;
            ResultSet TuesdayProfessorQuery = null;
            ResultSet WednesdayProfessorQuery = null;
            ResultSet ThursdayProfessorQuery = null;
            ResultSet FridayProfessorQuery = null;
            while (rs.next()) {
                TimeSchedule course = new TimeSchedule();
                course.setTimeBlock(rs.getTime("Time"));
                MondayVar = rs.getInt("Monday");
                TuesdayVar = rs.getInt("Tuesday");
                WednesdayVar = rs.getInt("Wednesday");
                ThursdayVar = rs.getInt("Thursday");
                FridayVar = rs.getInt("Friday");
                System.out.println(MondayVar + "  Monday MID VAR");
professorDetails = conn.createStatement();
                MondayProfessorQuery = professorDetails.executeQuery("SELECT master.section_id, master.course_id, courses.reference, Courses.course_name, professor.prof_name FROM master INNER JOIN Courses on (master.references= Courses.reference)  inner join professor on (master.prof_id = professor.prof_id) WHERE Master.m_id=" + MondayVar + ";");
                if (MondayProfessorQuery.first()) {
                    profName = MondayProfessorQuery.getString("prof_name");
                    mondayCourseName = MondayProfessorQuery.getString("course_name");
courseDetails = conn.createStatement();
                    mondayCourse = courseDetails.executeQuery("SELECT course_id from master where m_id =" + MondayVar + ";");
                    mondayCourse.first();
                    mondayCourseId = mondayCourse.getString("course_id");
                    insertToMon = "<b>Professor</b>: " + profName + "<hr/> <b>Course ID</b>: " + mondayCourseId + " <hr/> <b>Course Name:</b> " + mondayCourseName;
                } else
                    insertToMon = "No Class";
professorDetails = conn.createStatement();
                TuesdayProfessorQuery = professorDetails.executeQuery("SELECT master.section_id, master.course_id, courses.reference, Courses.course_name, professor.prof_name FROM master INNER JOIN Courses on (master.references= Courses.reference)  inner join professor on (master.prof_id = professor.prof_id) WHERE Master.m_id=" + TuesdayVar + ";");
                System.out.println(250);
                if (TuesdayProfessorQuery.first()) {
                    profName = TuesdayProfessorQuery.getString("prof_name");
                    System.out.println(258);
                    System.out.println(profName);
                    tuesdayCourseName = TuesdayProfessorQuery.getString("course_name");
courseDetails = conn.createStatement();
                    tuesdayCourse = courseDetails.executeQuery("SELECT course_id from master where m_id =" + TuesdayVar + ";");
                    tuesdayCourse.first();
                    System.out.println(270);
                    tuesdayCourseId = tuesdayCourse.getString("course_id");
                    insertToTues = "<b>Professor</b>: " + profName + "<hr/> <b>Course ID</b>: " + tuesdayCourseId + " <hr/> <b>Course Name:</b> " + tuesdayCourseName;
                } else {
                    insertToTues = "No Classes";
                    System.out.println(insertToTues + 276);
                }
professorDetails = conn.createStatement();
                WednesdayProfessorQuery = professorDetails.executeQuery("SELECT master.section_id, master.course_id, courses.reference, Courses.course_name, professor.prof_name FROM master INNER JOIN Courses on (master.references= Courses.reference)  inner join professor on (master.prof_id = professor.prof_id) WHERE Master.m_id=" + WednesdayVar + ";");
                if (WednesdayProfessorQuery.first()) {
                    profName = WednesdayProfessorQuery.getString("prof_name");
                    wednesdayCourseName = WednesdayProfessorQuery.getString("course_name");
courseDetails = conn.createStatement();
                    wednesdayCourse = courseDetails.executeQuery("SELECT course_id from master where m_id =" + WednesdayVar + ";");
                    wednesdayCourse.first();
                    wednesdayCourseId = wednesdayCourse.getString("course_id");
                    insertToWed = "<b>Professor</b>: " + profName + "<hr/> <b>Course ID</b>: " + wednesdayCourseId + " <hr/> <b>Course Name:</b> " + wednesdayCourseName;
                } else
                    insertToWed = "No Class";
professorDetails = conn.createStatement();
                ThursdayProfessorQuery = professorDetails.executeQuery("SELECT master.section_id, master.course_id, courses.reference, Courses.course_name, professor.prof_name FROM master INNER JOIN Courses on (master.references= Courses.reference)  inner join professor on (master.prof_id = professor.prof_id) WHERE Master.m_id=" + ThursdayVar + ";");
                if (ThursdayProfessorQuery.first()) {
                    profName = ThursdayProfessorQuery.getString("prof_name");
                    thursdayCourseName = ThursdayProfessorQuery.getString("course_name");
courseDetails = conn.createStatement();
                    thursdayCourse = courseDetails.executeQuery("SELECT course_id from master where m_id =" + ThursdayVar + ";");
                    thursdayCourse.first();
                    thursdayCourseId = thursdayCourse.getString("course_id");
                    insertToThurs = "<b>Professor</b>: " + profName + "<hr/> <b>Course ID</b>: " + thursdayCourseId + " <hr/> <b>Course Name:</b> " + thursdayCourseName;
                } else
                    insertToThurs = "No Class";
professorDetails = conn.createStatement();
                FridayProfessorQuery = professorDetails.executeQuery("SELECT master.section_id, master.course_id, courses.reference, Courses.course_name, professor.prof_name FROM master INNER JOIN Courses on (master.references= Courses.reference)  inner join professor on (master.prof_id = professor.prof_id) WHERE Master.m_id=" + FridayVar + ";");
                if (FridayProfessorQuery.first()) {
                    profName = FridayProfessorQuery.getString("prof_name");
                    fridayCourseName = FridayProfessorQuery.getString("course_name");
courseDetails = conn.createStatement();
                    fridayCourse = courseDetails.executeQuery("SELECT course_id from master where m_id =" + FridayVar + ";");
                    fridayCourse.first();
                    fridayCourseId = fridayCourse.getString("course_id");
                    insertToFri = "<b>Professor</b>: " + profName + "<hr/> <b>Course ID</b>: " + fridayCourseId + " <hr/> <b>Course Name:</b> " + fridayCourseName;
                } else
                    insertToFri = "No Class";
                course.setMonday(insertToMon);
                course.setTuesday(insertToTues);
                course.setWednesday(insertToWed);
                course.setThursday(insertToThurs);
                course.setFriday(insertToFri);
                course.setRoomInfo(rs.getString("building_name_no"));
                list.add(course);
            }
            professorDetails.close();
            MondayProfessorQuery.close();
            mondayCourse.close();
            tuesdayCourse.close();
            wednesdayCourse.close();
            thursdayCourse.close();
            fridayCourse.close();
            courseDetails.close();
            rs.close();
            stmt.close();
            conn.close();
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Output2.jsp");
        request.setAttribute("cust", list);
        dispatcher.forward(request, response);
    } catch (ServletException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    }
}}

