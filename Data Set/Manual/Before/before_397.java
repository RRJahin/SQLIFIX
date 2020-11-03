public class Dummy{
@Override
public void updateHostTeam(String playerName, String teamAbbr) {
    String sql = "update nba.players set currentteam="+teamAbbr+" where name="+playerName;
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

