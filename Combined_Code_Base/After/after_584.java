class Dummy{
public List<AlbumLista> buscarPorLista(long id) {
    this.conexao.abrirConexao();
    String sqlInsert = "SELECT * FROM Album_Lista " + "INNER JOIN Lista ON Album_Lista.id_lista = Lista.id_lista " + "INNER JOIN Usuario ON Lista.id_usuario = Usuario.id_usuario " + "INNER JOIN Album ON Album.id_album = Album_Lista.id_album " + "WHERE Album_Lista.id_lista=?;";
    PreparedStatement statement;
    AlbumLista albumLista = null;
    Album album = null;
    Lista lista = null;
    Usuario autor = null;
    List<AlbumLista> listaAlbumLista = new ArrayList<AlbumLista>();
    try {
        statement = this.conexao.getConexao().prepareStatement(sqlInsert);
        statement.setObject(1, id);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            autor = new Usuario(rs.getLong("id_usuario"), rs.getString("login_usuario"), rs.getString("senha_usuario"));
            lista = new Lista(rs.getLong("id_lista"), autor, rs.getString("nome_lista"), rs.getString("descricao_lista"));
            album = new Album(rs.getString("id_spotify"), rs.getLong("id_album"));
            albumLista = new AlbumLista(rs.getLong("id_album_lista"), album, lista);
            listaAlbumLista.add(albumLista);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        this.conexao.fecharConexao();
    }
    return listaAlbumLista;
}}

