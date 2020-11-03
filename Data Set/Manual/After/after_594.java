class Dummy{
@Override
public void remover(int cd_alimento) throws DBException {
    PreparedStatement pstmt = null;
    try {
        conexao = HealthTrackDbManager.getInstance().getConnection();
        String sql = "DELETE FROM T_HT_ALIMENTACAO WHERE CD_ALIMENTO = ?";
        pstmt = conexao.prepareStatement(sql);
        pstmt.setObject(1, cd_alimento);
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

