class Dummy{
public Album buscarPorId(long id) {
    this.conexao.abrirConexao();
    String sqlInsert = "SELECT * FROM Album WHERE id_album=?;";
    PreparedStatement statement;
    Album album = null;
    try {
        statement = this.conexao.getConexao().prepareStatement(sqlInsert);
        statement.setObject(1, id);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            album = new Album();
            album.setIdSpotify(rs.getString("id_spotify"));
            album.setIdAlbum(rs.getLong("id_album"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        this.conexao.fecharConexao();
    }
    return album;
}}
