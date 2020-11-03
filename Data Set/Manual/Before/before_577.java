class Dummy{
public Album cadastrarAlbum(Album album) {
    this.conexao.abrirConexao();
    String sqlInsert = "INSERT INTO Album VALUES("+album.getIdSpotify()+", null);";
    try {
        Statement statement = this.conexao.getConexao().createStatement();
        statement.executeUpdate(sqlInsert, Statement.RETURN_GENERATED_KEYS);
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

