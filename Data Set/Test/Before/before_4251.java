class Dummy{
public void testUpdatabilityAndEscaping() throws Exception {
    Properties props = new Properties();
    props.setProperty("useUnicode", "true");
    props.setProperty("characterEncoding", "big5");
    Connection updConn = getConnectionWithProps(props);
    Statement updStmt = updConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
    try {
updStmt = updConn.createStatement();
        updStmt.executeUpdate("DROP TABLE IF EXISTS testUpdatesWithEscaping");
updStmt = updConn.createStatement();
        updStmt.executeUpdate("CREATE TABLE testUpdatesWithEscaping (field1 INT PRIMARY KEY, field2 VARCHAR(64))");
updStmt = updConn.createStatement();
        updStmt.executeUpdate("INSERT INTO testUpdatesWithEscaping VALUES (1, null)");
        String stringToUpdate = "\" \\ '";
updStmt = updConn.createStatement();
        this.rs = updStmt.executeQuery("SELECT * from testUpdatesWithEscaping");
        this.rs.next();
        this.rs.updateString(2, stringToUpdate);
        this.rs.updateRow();
        assertTrue(stringToUpdate.equals(this.rs.getString(2)));
    } finally {
        updStmt.executeUpdate("DROP TABLE IF EXISTS testUpdatesWithEscaping");
        updStmt.close();
        updConn.close();
    }
}}

