public class Dummy{
@Override
public void atualizar(AtividadesFisicas atividadesFisicas) throws DBException {
    Statement pstmt = null;
    try {
        conexao = HealthTrackDbManager.getInstance().getConnection();
        String sql = "UPDATE T_HT_ATIVIDADE SET CD_ATIVIDADE = "+atividadesFisicas.getCd_atividade()+", DS_ATIVIDADE = "+ atividadesFisicas.getDs_atividade()+", CD_USUARIO = "+atividadesFisicas.getCd_usuario()+" WHERE CD_ATIVIDADE = "+atividadesFisicas.getCd_usuario();
        pstmt = conexao.createStatement();
        pstmt.executeUpdate(sql);
    } catch (SQLException e) {
        e.printStackTrace();
        throw new DBException("Erro ao atualizar.");
    } finally {
        try {
            pstmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}}

