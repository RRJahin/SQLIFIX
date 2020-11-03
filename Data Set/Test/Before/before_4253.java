class Dummy{
public void testUpdatabilityWithQuotes() throws Exception {
    Statement updStmt = null;
    try {
        createTable("testUpdWithQuotes", "(keyField CHAR(32) PRIMARY KEY NOT NULL, field2 int)");
        PreparedStatement pStmt = this.conn.prepareStatement("INSERT INTO testUpdWithQuotes VALUES (?, ?)");
        pStmt.setString(1, "Abe's");
        pStmt.setInt(2, 1);
pStmt = connection.createStatement();
        pStmt.executeUpdate();
        updStmt = this.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        this.rs = updStmt.executeQuery("SELECT * FROM testUpdWithQuotes");
        this.rs.next();
        this.rs.updateInt(2, 2);
        this.rs.updateRow();
    } finally {
        if (updStmt != null) {
            updStmt.close();
        }
        updStmt = null;
    }
}}

