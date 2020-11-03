class Dummy{
private void testSQL() {
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/iii?user=root&password=");
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("INSERT INTO cust (account,passwd) VALUES ('brad','123')");
        stmt.close();
        System.out.println("Insert OK");
    } catch (Exception e) {
        System.out.println(e);
    }
}}

