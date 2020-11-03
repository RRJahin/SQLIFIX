class Dummy{
public AlbumLista inserirEmLista(AlbumLista albumLista) {
    this.conexao.abrirConexao();
    String sqlInsert = "INSERT INTO Album_Lista VALUES(null, "+albumLista.getAlbum().getIdAlbum()+", "+albumLista.getLista().getIdLista()+");";
    try {
        Statement statement = this.conexao.getConexao().createStatement();
        statement.executeUpdate(sqlInsert, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = statement.getGeneratedKeys();
        if (rs.next()) {
            albumLista.setIdAlbumLista(rs.getLong(1));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        this.conexao.fecharConexao();
    }
    return albumLista;
}}

