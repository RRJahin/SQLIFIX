public class Dummy{
public void playerKilled(Player p) {
    PreparedStatement state;
    String uuid = p.getUniqueId().toString();
    int score = p.getScoreboard().getObjective("stats").getScore("kills").getScore();
    try {
        String query;
        query = "UPDATE stats SET kills = ? WHERE player = '?'";
        state = conn.prepareStatement(query);
        state.setObject(1, getKills(p) + score);
        state.setObject(2, uuid);
        state.executeUpdate();
        query = "UPDATE stats SET death = ? WHERE player = '?'";
        state.setObject(1, getDeaths(p) + 1);
        state.setObject(2, uuid);
        state.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}}

