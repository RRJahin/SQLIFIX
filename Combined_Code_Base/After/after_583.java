class Dummy{
public void excluirDaLista(long id) {
    this.conexao.abrirConexao();
    String sqlDelete = "DELETE FROM Album_Lista WHERE id_album_lista=?;";
    try {
        PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlDelete);
        statement.setObject(1, id);
        statement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        this.conexao.fecharConexao();
    }
}}

