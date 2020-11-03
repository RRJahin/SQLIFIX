public class Dummy{
public Integer updateNpc(Npc npc) {
    PreparedStatement stmt = null;
    try (Connection conn = Connections.getConnection()) {
        String sql = "Update npc set npc_name = ?,npc_lvl = ?, " + "currency = ?, job_id = ? WHERE npc_id=?";
        stmt = conn.prepareStatement(sql);
        stmt.setObject(1, npc.getName());
        stmt.setObject(2, npc.getLvl());
        stmt.setObject(3, npc.getCurrency());
        stmt.setObject(4, npc.getJobClass());
        stmt.setObject(5, npc.getId());
        return stmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        close(stmt);
    }
    return 0;
}}

