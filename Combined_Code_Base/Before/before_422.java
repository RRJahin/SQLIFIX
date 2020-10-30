public class Dummy{
private void doTheSecond() throws SQLException, DBException {
    Connection conn2 = null;
    Statement ps = null;
    try {
        conn2 = TestDAOFactory.getTestInstance().getConnection();
        ps = conn2.createStatement();
        ps.executeUpdate("INSERT INTO testincrement VALUES()");
        assertEquals(2L, DBUtil.getLastInsert((conn2)));
    } catch (SQLException ex) {
        throw ex;
    } finally {
        DBUtil.closeConnection(conn2, ps);
    }
}}

