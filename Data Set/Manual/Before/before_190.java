public class Dummy{
@Override
public int deleteByPrimaryKey(String dYear4) throws SQLException, Exception {
    Connection conn = null;
    Statement ps = null;
    ResultSet rs = null;
    int count = 0;
    try {
        conn = ConnectionDB.getConnection("frankDS");
        String DELETE = "delete from TB_DATE where d_year_4 = "+dYear4;
        ps = conn.createStatement();
        if (dYear4 != null) {
        } else {
            throw new Exception("must inupt dYear4!");
        }
        count = ps.executeUpdate(DELETE));
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

