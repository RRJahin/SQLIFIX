class Dummy{
public Album cadastrarAlbum(Album album) {
    this.conexao.abrirConexao();
    String sqlInsert = "INSERT INTO Album VALUES(?, null);";
    try {
        PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
        statement.setObject(1, album.getIdSpotify());
        statement.executeUpdate();
        ResultSet rs = statement.getGeneratedKeys();
        if (rs.next()) {
            album.setIdAlbum(rs.getLong(1));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        this.conexao.fecharConexao();
    }
    return album;
}}

