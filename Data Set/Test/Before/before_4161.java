class Dummy{
public void inserir(Categoria obj) throws SQLException {
    Connection con = util.Conexao.getConexao();
    String sql = "INSERT INTO categoria (descricao) " + "VALUES (?)";
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setString(1, obj.getDescricao());
ps = con.createStatement();
    ps.execute();
    String sql2 = "SELECT CURRVAL('categoria_id_seq') as  id;";
    Statement sta = con.createStatement();
    ResultSet rs = sta.executeQuery(sql2);
    while (rs.next()) {
        obj.setId(rs.getInt("id"));
    }
}}

