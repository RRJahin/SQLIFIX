public class Dummy{
public void addPlayer(Player p) {
    Statement state;
    try {
        state = conn.createStatement();
        state.executeUpdate("INSERT INTO `stats` (`player`, `kills`, `deaths`) VALUES ('" + p.getUniqueId().toString() + "', '0', '0')");
    } catch (SQLException e) {
        e.printStackTrace();
    }
}}

