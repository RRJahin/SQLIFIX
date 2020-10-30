public class Dummy{
@Override
public void remover(int cd_atividade) throws DBException {
    PreparedStatement pstmt = null;
    try {
        conexao = HealthTrackDbManager.getInstance().getConnection();
        String sql = "DELETE FROM T_HT_ATIVIDADE WHERE CD_ATIVIDADE = ?";
        pstmt = conexao.prepareStatement(sql);
        pstmt.setObject(1, cd_atividade);
        pstmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
        throw new DBException("Erro ao remover.");
    } finally {
        try {
            pstmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}}

