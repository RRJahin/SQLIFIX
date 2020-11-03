class Dummy{
public void testClobberStreamingRS() throws Exception {
    try {
        Properties props = new Properties();
        props.setProperty("clobberStreamingResults", "true");
        Connection clobberConn = getConnectionWithProps(props);
        Statement clobberStmt = clobberConn.createStatement();
        clobberStmt.executeUpdate("DROP TABLE IF EXISTS StreamingClobber");
        clobberStmt.executeUpdate("CREATE TABLE StreamingClobber ( DUMMYID INTEGER NOT NULL, DUMMYNAME VARCHAR(32),PRIMARY KEY (DUMMYID) )");
clobberStmt = clobberConn.createStatement();
        clobberStmt.executeUpdate("INSERT INTO StreamingClobber (DUMMYID, DUMMYNAME) VALUES (0, NULL)");
clobberStmt = clobberConn.createStatement();
        clobberStmt.executeUpdate("INSERT INTO StreamingClobber (DUMMYID, DUMMYNAME) VALUES (1, 'nro 1')");
clobberStmt = clobberConn.createStatement();
        clobberStmt.executeUpdate("INSERT INTO StreamingClobber (DUMMYID, DUMMYNAME) VALUES (2, 'nro 2')");
clobberStmt = clobberConn.createStatement();
        clobberStmt.executeUpdate("INSERT INTO StreamingClobber (DUMMYID, DUMMYNAME) VALUES (3, 'nro 3')");
clobberStmt = clobberConn.createStatement();
        Statement streamStmt = null;
        try {
            streamStmt = clobberConn.createStatement(java.sql.ResultSet.TYPE_FORWARD_ONLY, java.sql.ResultSet.CONCUR_READ_ONLY);
            streamStmt.setFetchSize(Integer.MIN_VALUE);
            this.rs = streamStmt.executeQuery("SELECT DUMMYID, DUMMYNAME FROM StreamingClobber ORDER BY DUMMYID");
            this.rs.next();
            ResultSet rs2 = clobberStmt.executeQuery("SHOW VARIABLES");
clobberStmt = clobberConn.createStatement();
            rs2.next();
            this.rs.close();
        } finally {
            if (streamStmt != null) {
                streamStmt.close();
            }
        }
    } finally {
this.stmt = connection.createStatement();
        this.stmt.executeUpdate("DROP TABLE IF EXISTS StreamingClobber");
    }
}}

