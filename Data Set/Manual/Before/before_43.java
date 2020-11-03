public class Dummy{
public int getKills(Player p) {
    Statement state;
    try {
        state = conn.createStatement();
        ResultSet result = state.executeQuery("SELECT kills FROM stats WHERE player = '" + p.getUniqueId().toString() + "'");
        result.next();
        return result.getInt("kills");
    } catch (SQLException e) {
    }
    return 0;
}}

