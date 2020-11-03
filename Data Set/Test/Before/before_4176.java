class Dummy{
private void addAccount(String account, String passwd) {
    String salt = BCrypt.gensalt(12);
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Properties prop = new Properties();
        prop.setProperty("user", "root");
        prop.setProperty("password", "");
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/iii", prop);
        Statement stmt = conn.createStatement();
        stmt.executeQuery("SET NAMES UTF8");
        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO cust (account,passwd) VALUES (?,?)");
        pstmt.setString(1, account);
        pstmt.setString(2, BCrypt.hashpw(passwd, salt));
pstmt = conn.createStatement();
        pstmt.executeUpdate();
        System.out.println("Insert OK");
    } catch (Exception e) {
        System.out.println(e);
    }
}}

