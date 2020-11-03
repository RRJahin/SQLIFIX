class Dummy{
@Override
public void cadastrar(Alimentacao alimentacao) throws DBException {
    Statement pstmt = null;
    try {
        conexao = HealthTrackDbManager.getInstance().getConnection();
        pstmt = conexao.createStatement();
        java.sql.Date data = new java.sql.Date(alimentacao.getDt_registro().getTimeInMillis());
        String sql = "INSERT INTO T_HT_ALIMENTACAO (CD_ALIMENTO, DS_ALIMENTO, CD_USUARIO, VL_CALORIAS_GANHAS, DT_REGISTRO) VALUES (SQ_T_HT_ALIMENTACAO.NEXTVAL, "+alimentacao.getDs_alimento()+", "+alimentacao.getCd_usuario()+", "+alimentacao.getVl_calorias_ganhas()+", "+data+")";
        pstmt.executeUpdate(sql);
    } catch (SQLException e) {
        e.printStackTrace();
        throw new DBException("Erro ao cadastrar.");
    } finally {
        try {
            pstmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}}

