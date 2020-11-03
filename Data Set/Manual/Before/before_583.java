class Dummy{
public void excluirDaLista(long id) {
    this.conexao.abrirConexao();
    String sqlDelete = "DELETE FROM Album_Lista WHERE id_album_lista="+id+";";
    try {
        Statement statement = this.conexao.getConexao().createStatement();
        statement.executeUpdate(sqlDelete);
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        this.conexao.fecharConexao();
    }
}}

