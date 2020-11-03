class Dummy{
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    context = getServletContext();
    try {
        Connection conn1 = (Connection) context.getAttribute("conn");
        Statement stmt = conn1.createStatement();
        HttpSession session = request.getSession(false);
        if (session != null) {
            String dbid = (String) session.getAttribute("dbid");
            stmt.executeUpdate("update member set islogin=0 where id=" + dbid);
            session.invalidate();
        }
        System.out.println("OK2");
    } catch (Exception e) {
        System.out.println(e.toString());
    }
}}

