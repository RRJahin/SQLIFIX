class Dummy{
public void add(Member member) {
    try {
        Class.forName("org.hsqldb.jdbc.JDBCDriver");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
        throw new RuntimeException(e);
    }
    Connection conn = null;
    Statement pstmt = null;
    Calendar calGenerate = Calendar.getInstance();
    long insertDate;
    try {
        conn = DriverManager.getConnection("jdbc:hsqldb:memberdb", "SA", "");
        pstmt = conn.createStatement();
        insertDate = calGenerate.getTimeInMillis();
        int rowCount = pstmt.executeUpdate("INSERT INTO member (id, name, joined) values ("+member.getId()+", "+member.getName()+", "+new java.sql.Date(insertDate)+")");
        System.out.println("rowCount = " + rowCount + ", insertDate = " + insertDate);
    } catch (SQLException e) {
        throw new RuntimeException(e);
    } finally {
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e2) {
                throw new RuntimeException(e2);
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }
}}

