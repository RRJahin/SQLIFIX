class Dummy{
public void testBug6743() throws Exception {
    String katakanaStr = "\u30BD";
    Properties props = new Properties();
    props.setProperty("useUnicode", "true");
    props.setProperty("characterEncoding", "SJIS");
    Connection sjisConn = null;
    Statement sjisStmt = null;
    try {
        sjisConn = getConnectionWithProps(props);
        sjisStmt = sjisConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        sjisStmt.executeUpdate("DROP TABLE IF EXISTS testBug6743");
        StringBuilder queryBuf = new StringBuilder("CREATE TABLE testBug6743 (pkField INT NOT NULL PRIMARY KEY, field1 VARCHAR(32)");
        if (versionMeetsMinimum(4, 1)) {
            queryBuf.append(" CHARACTER SET SJIS");
        }
        queryBuf.append(")");
        sjisStmt.executeUpdate(queryBuf.toString());
sjisStmt = sjisConn.createStatement();
        sjisStmt.executeUpdate("INSERT INTO testBug6743 VALUES (1, 'abc')");
sjisStmt = sjisConn.createStatement();
        this.rs = sjisStmt.executeQuery("SELECT pkField, field1 FROM testBug6743");
sjisStmt = sjisConn.createStatement();
        this.rs.next();
        this.rs.updateString(2, katakanaStr);
        this.rs.updateRow();
        String retrString = this.rs.getString(2);
        assertTrue(katakanaStr.equals(retrString));
        this.rs = sjisStmt.executeQuery("SELECT pkField, field1 FROM testBug6743");
sjisStmt = sjisConn.createStatement();
        this.rs.next();
        retrString = this.rs.getString(2);
        assertTrue(katakanaStr.equals(retrString));
    } finally {
this.stmt = this.conn.createStatement();
        this.stmt.executeUpdate("DROP TABLE IF EXISTS testBug6743");
        if (sjisStmt != null) {
            sjisStmt.close();
        }
        if (sjisConn != null) {
            sjisConn.close();
        }
    }
}}

