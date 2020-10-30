public class Dummy{
@Override
public void cadastrar(AtividadesFisicas atividadesFisicas) throws DBException {
    PreparedStatement pstmt = null;
    try {
        conexao = HealthTrackDbManager.getInstance().getConnection();
        String sql = "INSERT INTO T_HT_ATIVIDADE (CD_ATIVIDADE, DT_ATIVIDADE, DS_ATIVIDADE, CD_USUARIO) VALUES (SQ_T_HT_ATIVIDADE.NEXTVAL, ?, ?, ?)";
        java.sql.Date data = new java.sql.Date(atividadesFisicas.getDt_atividade().getTimeInMillis());
        pstmt = conexao.prepareStatement(sql);
        pstmt.setObject(1, data);
        pstmt.setObject(2, atividadesFisicas.getDs_atividade());
        pstmt.setObject(3, atividadesFisicas.getCd_usuario());
        pstmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
        throw new DBException("Erro ao cadastradar.");
    } finally {
        try {
            pstmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}}

