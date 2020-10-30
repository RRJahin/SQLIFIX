public class Dummy{
public Integer updateNpc(Npc npc) {
    Statement stmt = null;
    try (Connection conn = Connections.getConnection()) {
        String sql = "Update npc set npc_name = "+npc.getName()+",npc_lvl = "+npc.getLvl()+", " + "currency = "+npc.getCurrency()+", job_id = "+npc.getJobClass()+" WHERE npc_id="+npc.getId();
        stmt = conn.createStatement();
        return stmt.executeUpdate(sql);
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        close(stmt);
    }
    return 0;
}}

