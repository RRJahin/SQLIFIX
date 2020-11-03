class Dummy{
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    servletContext = getServletContext();
    try {
        conn1 = (Connection) servletContext.getAttribute("conn");
        Statement stmt = conn1.createStatement();
        stmt.executeUpdate("insert into member (account,passwd,realname) values ('aa','bb','cc')");
        System.out.println("OK2");
    } catch (Exception e) {
        System.out.println(e.toString());
    }
    try {
        Class.forName("com.mysql.jdbc.Driver");
        conn2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:9487/brad", "root", "root");
    } catch (Exception e) {
        System.out.println(e.toString());
    }
    System.out.println(conn1 == conn2);
}}

