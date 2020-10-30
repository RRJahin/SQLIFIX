class Dummy{
@Override
public void cadastrar(Alimentacao alimentacao) throws DBException {
    PreparedStatement pstmt = null;
    try {
        conexao = HealthTrackDbManager.getInstance().getConnection();
        String sql = "INSERT INTO T_HT_ALIMENTACAO (CD_ALIMENTO, DS_ALIMENTO, CD_USUARIO, VL_CALORIAS_GANHAS, DT_REGISTRO) VALUES (SQ_T_HT_ALIMENTACAO.NEXTVAL, ?, ?, ?, ?)";
        pstmt = conexao.prepareStatement(sql);
        pstmt.setObject(1, alimentacao.getDs_alimento());
        pstmt.setObject(2, alimentacao.getCd_usuario());
        pstmt.setObject(3, alimentacao.getVl_calorias_ganhas());
        java.sql.Date data = new java.sql.Date(alimentacao.getDt_registro().getTimeInMillis());
        pstmt.setDate(4, data);
        pstmt.executeUpdate();
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

