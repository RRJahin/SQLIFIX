public class Dummy{
public void testNoIncrementCollision() throws DBException {
    Connection conn1 = null;
    PreparedStatement ps = null;
    try {
        conn1 = TestDAOFactory.getTestInstance().getConnection();
        ps = conn1.prepareStatement("INSERT INTO testincrement VALUES()");
        ps.executeUpdate();
        doTheSecond();
        assertEquals(1L, DBUtil.getLastInsert(conn1));
    } catch (SQLException ex) {
    } finally {
        DBUtil.closeConnection(conn1, ps);
    }
}}

