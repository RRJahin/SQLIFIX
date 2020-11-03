class Dummy{
protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
    try {
        Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException cnfe) {
        System.err.print("Error loaing driver" + cnfe);
    }
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
        session = request.getSession(true);
        if (session.isNew() == false) {
            session.invalidate();
            session = request.getSession(true);
        }
        String studentID = request.getParameter("sID");
        String studentPass = request.getParameter("sPass");
        Connection Con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3309/MiniUniversity", "root", "admin");
        Statement stmt = (Statement) Con.createStatement();
        Statement stmt2 = (Statement) Con.createStatement();
        ResultSet rs = stmt.executeQuery("select Name from Student where SSN = '" + studentID + "'");
        ResultSet rs2 = stmt2.executeQuery("select Password from Student where SSN = '" + studentID + "'");
        boolean idCheck = false, passCheck = false;
        String res = "";
        String res2 = "";
        while (rs.next()) {
            idCheck = true;
            res = rs.getString("Name");
        }
        while (rs2.next()) {
            res2 = rs2.getString("Password");
        }
        if (res2.equals(studentPass))
            passCheck = true;
        if (!idCheck || !passCheck) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>ERROR!</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h3>");
            out.println("Student ID doesn't exist or wrong password...Press return button to go back to " + "login form");
            out.println("</h3");
            out.println("<br><br>");
            out.println("<form action='index.html'>");
            out.println("<br>");
            out.println("<input type='submit' value='Return'>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
            out.close();
        } else {
            session.setAttribute("studentName", res);
            session.setAttribute("sID", studentID);
            response.sendRedirect("availableCourses.jsp");
            out.close();
        }
        out.close();
    }
}}

