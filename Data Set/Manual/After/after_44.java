public class Dummy{
public int getDeaths(Player p) {
    PreparedStatement state;
    try {
        String query = "SELECT death FROM stats WHERE player = '?'";
        state = conn.createStatement(query);
        state.setObject(1, p.getUniqueId().toString());
        ResultSet result = state.executeQuery();
        result.next();
        return result.getInt("death");
    } catch (SQLException e) {
    }
    return 0;
}}

