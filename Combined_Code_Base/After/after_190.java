public class Dummy{
@Override
public int deleteByPrimaryKey(String dYear4) throws SQLException, Exception {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    int count = 0;
    try {
        conn = ConnectionDB.getConnection("frankDS");
        String DELETE = "delete from TB_DATE where d_year_4 = ?";
        ps = conn.prepareStatement(DELETE);
        if (dYear4 != null) {
            ps.setObject(1, dYear4);
        } else {
            throw new Exception("must inupt dYear4!");
        }
        count = ps.executeUpdate();
        System.out.println("delete count : " + count);
    } catch (SQLException e) {
        e.printStackTrace();
        throw e;
    } finally {
        ConnectionDB.closeJDBCConnection(conn);
        ConnectionDB.closePreparedStatement(ps);
        ConnectionDB.closeResultSet(rs);
    }
    return count;
}}

