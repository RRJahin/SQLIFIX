public class Dummy{
@Override
public void atualizar(AtividadesFisicas atividadesFisicas) throws DBException {
    PreparedStatement pstmt = null;
    try {
        conexao = HealthTrackDbManager.getInstance().getConnection();
        String sql = "UPDATE T_HT_ATIVIDADE SET CD_ATIVIDADE = ?, DS_ATIVIDADE = ?, CD_USUARIO = ? WHERE CD_ATIVIDADE = ?";
        pstmt = conexao.prepareStatement(sql);
        pstmt.setObject(1, atividadesFisicas.getCd_atividade());
        pstmt.setObject(2, atividadesFisicas.getDs_atividade());
        pstmt.setObject(3, atividadesFisicas.getCd_usuario());
        pstmt.setObject(4, atividadesFisicas.getCd_usuario());
        pstmt.executeUpdate();
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

