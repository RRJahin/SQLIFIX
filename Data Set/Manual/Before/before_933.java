public class Dummy{
@Override
public void cadastrar(AtividadesFisicas atividadesFisicas) throws DBException {
    Statement pstmt = null;
    try {
        conexao = HealthTrackDbManager.getInstance().getConnection();
        String sql = "INSERT INTO T_HT_ATIVIDADE (CD_ATIVIDADE, DT_ATIVIDADE, DS_ATIVIDADE, CD_USUARIO) VALUES (SQ_T_HT_ATIVIDADE.NEXTVAL, "+data+", "+atividadesFisicas.getDs_atividade()+", "+atividadesFisicas.getCd_usuario()+")";
        java.sql.Date data = new java.sql.Date(atividadesFisicas.getDt_atividade().getTimeInMillis());
        pstmt = conexao.createStatement();
        pstmt.executeUpdate(sql);
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

