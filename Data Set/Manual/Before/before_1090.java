public class Dummy{
public void testNoIncrementCollision() throws DBException {
    Connection conn1 = null;
    Statement ps = null;
    try {
        conn1 = TestDAOFactory.getTestInstance().getConnection();
        ps = conn1.createStatement();
        ps.executeUpdate("INSERT INTO testincrement VALUES()");
        doTheSecond();
        assertEquals(1L, DBUtil.getLastInsert(conn1));
    } catch (SQLException ex) {
    } finally {
        DBUtil.closeConnection(conn1, ps);
    }
}}

