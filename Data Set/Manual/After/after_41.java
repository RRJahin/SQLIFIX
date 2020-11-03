public class Dummy{
public boolean isNewPlayer(Player p) {
    PreparedStatement state;
    try {
        String query = "SELECT player FROM stats WHERE player = '?'";
        state = conn.prepareStatement(query);
        state.setObject(1, p.getUniqueId().toString());
        ResultSet result = state.executeQuery();
        if (!result.next()) {
            return true;
        }
    } catch (SQLException e) {
    }
    return false;
}}

