class Dummy{
public AlbumLista inserirEmLista(AlbumLista albumLista) {
    this.conexao.abrirConexao();
    String sqlInsert = "INSERT INTO Album_Lista VALUES(null, ?, ?);";
    try {
        PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
        statement.setObject(1, albumLista.getAlbum().getIdAlbum());
        statement.setObject(2, albumLista.getLista().getIdLista());
        statement.executeUpdate();
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

