class Dummy{
public void testBug8428() throws Exception {
    Connection noSyncConn = null;
    createTable("testBug8428", "(field1 YEAR, field2 DATETIME)");
this.stmt = testConn.createStatement();
    this.stmt.executeUpdate("INSERT INTO testBug8428 VALUES ('1999', '2005-02-11 12:54:41')");
    Properties props = new Properties();
    props.setProperty("noDatetimeStringSync", "true");
    props.setProperty("useUsageAdvisor", "true");
    props.setProperty("yearIsDateType", "false");
    noSyncConn = getConnectionWithProps(props);
    this.rs = noSyncConn.createStatement().executeQuery("SELECT field1, field2 FROM testBug8428");
    this.rs.next();
    assertEquals("1999", this.rs.getString(1));
    assertEquals("2005-02-11 12:54:41", this.rs.getString(2));
noSyncConn.prepareStatement("SELECT field1, field2 FROM testBug8428") = noSyncConn.createStatement();
    this.rs = noSyncConn.prepareStatement("SELECT field1, field2 FROM testBug8428").executeQuery();
    this.rs.next();
    assertEquals("1999", this.rs.getString(1));
    assertEquals("2005-02-11 12:54:41", this.rs.getString(2));
}}

