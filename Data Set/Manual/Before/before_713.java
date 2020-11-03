public class Dummy{
public int getDeaths(Player p) {
    Statement state;
    try {
        state = conn.createStatement();
        ResultSet result = state.executeQuery("SELECT death FROM stats WHERE player = '" + p.getUniqueId().toString() + "'");
        result.next();
        return result.getInt("death");
    } catch (SQLException e) {
    }
    return 0;
}}

