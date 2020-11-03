public class Dummy{
public void playerKilled(Player p) {
    Statement state;
    String uuid = p.getUniqueId().toString();
    int score = p.getScoreboard().getObjective("stats").getScore("kills").getScore();
    try {
        state = conn.createStatement();
        state.executeUpdate("UPDATE stats SET kills = " + getKills(p) + score + " WHERE player = '" + uuid + "'");
        state.executeUpdate("UPDATE stats SET death = " + getDeaths(p) + 1 + " WHERE player = '" + uuid + "'");
    } catch (SQLException e) {
        e.printStackTrace();
    }
}}

