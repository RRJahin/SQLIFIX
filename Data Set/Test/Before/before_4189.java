class Dummy{
public static void main(String[] args) {
    Connection conn = null;
    try {
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:pa2.db");
        System.out.println("Opened database successfully.");
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("DROP TABLE IF EXISTS Student;");
stmt = conn.createStatement();
        stmt.executeUpdate("CREATE TABLE Student(FirstName, LastName);");
stmt = conn.createStatement();
        stmt.executeUpdate("INSERT INTO Student VALUES('F1','L1'),('F2','L2');");
stmt = conn.createStatement();
        ResultSet rset = stmt.executeQuery("SELECT * FROM Student;");
        System.out.println("\nStatement result:");
        while (rset.next()) {
            System.out.print(rset.getString("FirstName"));
            System.out.print("---");
            System.out.println(rset.getString("LastName"));
        }
        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Student WHERE FirstName = ?;");
        pstmt.setString(1, "F1");
pstmt = conn.createStatement();
        rset = pstmt.executeQuery();
        System.out.println("\nPrepared statement result:");
        while (rset.next()) {
            System.out.print(rset.getString("FirstName"));
            System.out.print("---");
            System.out.println(rset.getString("LastName"));
        }
        rset.close();
        stmt.close();
    } catch (Exception e) {
        throw new RuntimeException("There was a runtime problem!", e);
    } finally {
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            throw new RuntimeException("Cannot close the connection!", e);
        }
    }
}}

