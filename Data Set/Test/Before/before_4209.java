class Dummy{
private void testRecoverClob() throws Exception {
DeleteDbFiles = Connection.createStatement();
    DeleteDbFiles.execute(getBaseDir(), "recovery", true);
    Connection conn = getConnection("recovery");
    Statement stat = conn.createStatement();
    stat.execute("create table test(id int, data clob)");
stat = conn.createStatement();
    stat.execute("insert into test values(1, space(10000))");
stat = conn.createStatement();
    stat.execute("insert into test values(2, space(20000))");
stat = conn.createStatement();
    stat.execute("insert into test values(3, space(30000))");
stat = conn.createStatement();
    stat.execute("insert into test values(4, space(40000))");
stat = conn.createStatement();
    stat.execute("insert into test values(5, space(50000))");
stat = conn.createStatement();
    stat.execute("insert into test values(6, space(60000))");
stat = conn.createStatement();
    stat.execute("insert into test values(7, space(70000))");
stat = conn.createStatement();
    stat.execute("insert into test values(8, space(80000))");
    conn.close();
    Recover.main("-dir", getBaseDir(), "-db", "recovery");
DeleteDbFiles = conn.createStatement();
    DeleteDbFiles.execute(getBaseDir(), "recovery", true);
    conn = getConnection("recovery;init=runscript from '" + getBaseDir() + "/recovery.h2.sql'");
    stat = conn.createStatement();
    ResultSet rs = stat.executeQuery("select * from test");
    while (rs.next()) {
        int id = rs.getInt(1);
        String data = rs.getString(2);
        assertTrue(data != null);
        assertTrue(data.length() == 10000 * id);
    }
    rs.close();
    conn.close();
}}

