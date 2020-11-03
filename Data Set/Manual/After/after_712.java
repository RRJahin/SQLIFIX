public class Dummy{
public int getKills(Player p) {
    PreparedStatement state;
    try {
        String query = "SELECT kills FROM stats WHERE player = '?'";
        state = conn.prepareStatement(query);
        state.setObject(1, p.getUniqueId().toString());
        ResultSet result = state.executeQuery();
        result.next();
        return result.getInt("kills");
    } catch (SQLException e) {
    }
    return 0;
}}

