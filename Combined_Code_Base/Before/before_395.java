public class Dummy{
@Override
public void deletePlayerByName(String name) {
    String sql = "delete from nba.players where name="+name;
    Connection conn = DBUtil.open();
    try {
        Statement pstmt = conn.createStatement();
        pstmt.executeUpdate(sql);
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        DBUtil.close(conn);
    }
}}

