class Dummy{
@Override
public void atualizar(Alimentacao alimentacao) throws DBException {
    PreparedStatement pstmt = null;
    try {
        conexao = HealthTrackDbManager.getInstance().getConnection();
        String sql = "UPDATE T_HT_ALIMENTACAO SET CD_ALIMENTO = ?, DS_ALIMENTO = ?, CD_USUARIO = ?, VL_CALORIAS_GANHAS = ?, DT_REGISTRO = ? WHERE CD_ALIMENTO = ?";
        pstmt = conexao.prepareStatement(sql);
        pstmt.setObject(1, alimentacao.getCd_alimento());
        pstmt.setObject(2, alimentacao.getDs_alimento());
        pstmt.setObject(3, alimentacao.getCd_usuario());
        pstmt.setObject(4, alimentacao.getVl_calorias_ganhas());
        java.sql.Date data = new java.sql.Date(alimentacao.getDt_registro().getTimeInMillis());
        pstmt.setDate(5, data);
        pstmt.setObject(6, alimentacao.getCd_alimento());
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

