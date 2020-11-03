public class Dummy{
public void addPlayer(Player p) {
    PreparedStatement state;
    try {
        String query = "INSERT INTO `stats` (`player`, `kills`, `deaths`) VALUES ('?', '0', '0')";
        state = conn.prepareStatement(query);
        state.setObject(1, p.getUniqueId().toString());
        state.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}}

