class Dummy{
protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
        String studentID = request.getSession().getAttribute("sID").toString();
        int nSelected = Integer.parseInt(String.valueOf(request.getSession().getAttribute("nSelected")));
        ArrayList<String> selected = (ArrayList) request.getSession().getAttribute("selectedCourses");
        Connection Con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3309/MiniUniversity", "root", "admin");
        for (int i = 0; i < nSelected; i++) {
            Statement stmt = (Statement) Con.createStatement();
            ResultSet rs = stmt.executeQuery("select CrsCode from Course where Name = '" + selected.get(i) + "'");
            String crsCode = "";
            while (rs.next()) {
                crsCode = rs.getString("crsCode");
            }
            String semester = request.getParameter("sub" + String.valueOf(i));
            Statement stmt2 = (Statement) Con.createStatement();
            stmt2.executeUpdate("Insert Into Registered Values ('" + String.valueOf(studentID) + "','" + crsCode + "','" + semester + "',2015);");
        }
        Statement stmt1 = (Statement) Con.createStatement();
        ResultSet rs2 = stmt1.executeQuery("select Course.Name from Course where CrsCode in (select CrsCode from Registered where Registered.SSN = " + studentID + ")");
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Mini-university App</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1> Registered courses are : </h1>");
        out.println("<br> <br>");
        while (rs2.next()) {
            out.println(rs2.getString("Name"));
            out.println("<br>");
        }
        out.println("</body>");
        out.println("</html>");
        checkExistance.session.invalidate();
        out.close();
    }
}}

