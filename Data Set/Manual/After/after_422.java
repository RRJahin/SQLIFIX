public class Dummy{
private void doTheSecond() throws SQLException, DBException {
    Connection conn2 = null;
    PreparedStatement ps = null;
    try {
        conn2 = TestDAOFactory.getTestInstance().getConnection();
        ps = conn2.prepareStatement("INSERT INTO testincrement VALUES()");
        ps.executeUpdate();
        assertEquals(2L, DBUtil.getLastInsert((conn2)));
    } catch (SQLException ex) {
        throw ex;
    } finally {
        DBUtil.closeConnection(conn2, ps);
    }
}}

