class Dummy{
@Override
public void atualizar(Alimentacao alimentacao) throws DBException {
    Statement pstmt = null;
    try {
        conexao = HealthTrackDbManager.getInstance().getConnection();
        pstmt = conexao.createStatement();
        java.sql.Date data = new java.sql.Date(alimentacao.getDt_registro().getTimeInMillis());
        String sql = "UPDATE T_HT_ALIMENTACAO SET CD_ALIMENTO = "+alimentacao.getCd_alimento()+", DS_ALIMENTO = "+alimentacao.getDs_alimento()+", CD_USUARIO = "+alimentacao.getCd_usuario()+", VL_CALORIAS_GANHAS ="+alimentacao.getVl_calorias_ganhas()+", DT_REGISTRO = "+data+" WHERE CD_ALIMENTO = "+alimentacao.getCd_alimento();
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

