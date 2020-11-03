class Dummy{
public void testBug6561() throws Exception {
    Connection testConn = this.conn;
    Connection zeroConn = getConnectionWithProps("zeroDateTimeBehavior=convertToNull");
    try {
        if (versionMeetsMinimum(5, 7, 4)) {
            Properties props = new Properties();
            props.put("jdbcCompliantTruncation", "false");
            if (versionMeetsMinimum(5, 7, 5)) {
                String sqlMode = getMysqlVariable("sql_mode");
                if (sqlMode.contains("STRICT_TRANS_TABLES")) {
                    sqlMode = removeSqlMode("STRICT_TRANS_TABLES", sqlMode);
                    props.put("sessionVariables", "sql_mode='" + sqlMode + "'");
                }
            }
            testConn = getConnectionWithProps(props);
            this.stmt = testConn.createStatement();
        }
        createTable("testBug6561", "(ofield int, field1 DATE, field2 integer, field3 integer)");
        this.stmt.executeUpdate("INSERT INTO testBug6561 (ofield, field1,field2,field3)	VALUES (1, 0,NULL,0)");
this.stmt = testConn.createStatement();
        this.stmt.executeUpdate("INSERT INTO testBug6561 (ofield, field1,field2,field3) VALUES (2, '2004-11-20',NULL,0)");
        PreparedStatement ps = zeroConn.prepareStatement("SELECT field1,field2,field3 FROM testBug6561 ORDER BY ofield");
ps = testConn.createStatement();
        this.rs = ps.executeQuery();
        assertTrue(this.rs.next());
        assertNull(this.rs.getObject("field1"));
        assertNull(this.rs.getObject("field2"));
        assertEquals(0, this.rs.getInt("field3"));
        assertTrue(this.rs.next());
        assertEquals("2004-11-20", this.rs.getString("field1"));
        assertNull(this.rs.getObject("field2"));
        assertEquals(0, this.rs.getInt("field3"));
        ps.close();
    } finally {
        zeroConn.close();
        if (testConn != this.conn) {
            testConn.close();
        }
    }
}}

