public class Dummy{
@Override
public void delGuitar(String SerialNumber) {
    Connection Conn = MySqlDBUtil.open();
    String sql = "delete from guitar where SerialNumber = ?";
    try {
        PreparedStatement pstmt = Conn.prepareStatement(sql);
        pstmt.setObject(1, SerialNumber);
        pstmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        MySqlDBUtil.close(Conn);
    }
}}

