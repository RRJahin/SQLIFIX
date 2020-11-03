class Dummy{
public void testBug5664() throws Exception {
    createTable("testBug5664", "(pkfield int PRIMARY KEY NOT NULL, field1 SMALLINT)");
this.stmt = this.conn.createStatement();
    this.stmt.executeUpdate("INSERT INTO testBug5664 VALUES (1, 1)");
    Statement updatableStmt = this.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    this.rs = updatableStmt.executeQuery("SELECT pkfield, field1 FROM testBug5664");
    this.rs.next();
    this.rs.moveToInsertRow();
    this.rs.updateInt(1, 2);
    this.rs.updateByte(2, (byte) 2);
}}

