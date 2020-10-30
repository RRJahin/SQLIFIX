public class Dummy{
public Npc selectNpcById(Integer id) {
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = "SELECT * FROM npc WHERE npc_id = ?";
    try (Connection conn = Connections.getConnection()) {
        ps = conn.prepareStatement(sql);
        ps.setObject(1, id);
        rs = ps.executeQuery();
        while (rs.next()) {
            return new Npc(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        close(rs);
        close(ps);
    }
    return null;
}}

