class Dummy {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Demo", "sa", "sa");
        Statement pstmt = con.createStatement();
        int x = pstmt.executeUpdate("update love set people=aaaaa where book=" + 1);
        System.out.println(x);
        pstmt.close();
        con.close();
    }
}
