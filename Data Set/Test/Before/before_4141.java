class Dummy{
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    context = getServletContext();
    try {
        Connection conn1 = (Connection) context.getAttribute("conn");
        Statement stmt = conn1.createStatement();
        ResultSet rs = stmt.executeQuery("select * from member where account='brad' and islogin=0");
        if (rs.next()) {
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(60);
stmt = conn1.createStatement();
            stmt.executeUpdate("update member set islogin=1 where account='brad'");
            session.setAttribute("dbid", "1");
            System.out.println("new Login");
        } else {
            System.out.println("Login already!");
        }
    } catch (Exception e) {
        System.out.println(e.toString());
    }
}}

