class Dummy{
public Album buscarPorIdSpotify(String idSpotify) {
    this.conexao.abrirConexao();
    String sqlInsert = "SELECT * FROM Album WHERE id_spotify="+idSpotify+";";
    Statement statement;
    Album album = null;
    try {
        statement = this.conexao.getConexao().createStatement();
        ResultSet rs = statement.executeQuery(sqlInsert);
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

