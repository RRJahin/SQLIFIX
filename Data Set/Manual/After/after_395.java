public class Dummy{
@Override
public void deletePlayerByName(String name) {
    String sql = "delete from nba.players where name=?";
    Connection conn = DBUtil.open();
    try {
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setObject(1, name);
        pstmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        DBUtil.close(conn);
    }
}}

