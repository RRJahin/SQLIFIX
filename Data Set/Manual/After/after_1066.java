public class Dummy{
@Override
public void updateHostTeam(String playerName, String teamAbbr) {
    String sql = "update nba.players set currentteam=? where name=?";
    Connection conn = DBUtil.open();
    try {
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setObject(1, teamAbbr);
        pstmt.setObject(2, playerName);
        pstmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        DBUtil.close(conn);
    }
}}

