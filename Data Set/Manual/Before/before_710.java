public class Dummy{
public boolean isNewPlayer(Player p) {
    PreparedStatement state;
    try {
        state = conn.createStatement();
        ResultSet result = state.executeQuery("SELECT player FROM stats WHERE player = '" + p.getUniqueId().toString() + "'");
        if (!result.next()) {
            return true;
        }
    } catch (SQLException e) {
    }
    return false;
}}

