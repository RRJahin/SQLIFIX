public class Dummy{
@Override
public void remover(int cd_atividade) throws DBException {
    Statement pstmt = null;
    try {
        conexao = HealthTrackDbManager.getInstance().getConnection();
        String sql = "DELETE FROM T_HT_ATIVIDADE WHERE CD_ATIVIDADE = "+cd_atividade;
        pstmt = conexao.createStatement();
        pstmt.executeUpdate(sql);
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

