class Dummy{
public void testUpdateClob() throws Exception {
    Statement updatableStmt = this.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    createTable("testUpdateClob", "(intField INT NOT NULL PRIMARY KEY, clobField TEXT)");
    this.stmt.executeUpdate("INSERT INTO testUpdateClob VALUES (1, 'foo')");
updatableStmt = this.conn.createStatement();
    this.rs = updatableStmt.executeQuery("SELECT intField, clobField FROM testUpdateClob");
    this.rs.next();
    Clob clob = this.rs.getClob(2);
    clob.setString(1, "bar");
    this.rs.updateClob(2, clob);
    this.rs.updateRow();
    this.rs.moveToInsertRow();
    clob.setString(1, "baz");
    this.rs.updateInt(1, 2);
    this.rs.updateClob(2, clob);
    this.rs.insertRow();
    clob.setString(1, "bat");
    this.rs.updateInt(1, 3);
    this.rs.updateClob(2, clob);
    this.rs.insertRow();
    this.rs.close();
this.stmt = this.conn.createStatement();
    this.rs = this.stmt.executeQuery("SELECT intField, clobField FROM testUpdateClob ORDER BY intField");
    this.rs.next();
    assertTrue((this.rs.getInt(1) == 1) && this.rs.getString(2).equals("bar"));
    this.rs.next();
    assertTrue((this.rs.getInt(1) == 2) && this.rs.getString(2).equals("baz"));
    this.rs.next();
    assertTrue((this.rs.getInt(1) == 3) && this.rs.getString(2).equals("bat"));
}}

