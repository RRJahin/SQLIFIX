class Dummy{
public void inserir(Produto camarote) throws SQLException {
    Connection con = util.Conexao.getConexao();
    String sql = "INSERT INTO ingresso ( local, datahora, lugar, quantidade, idcategoria, idtipoingresso, valor) " + "VALUES (?,?,?,?,?,?,?)";
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setString(1, camarote.getLocal());
    ps.setDate(2, new java.sql.Date(camarote.getDataHora().getTime()));
    ps.setString(3, camarote.getLugar());
    ps.setInt(4, camarote.getQuantidade());
    ps.setInt(5, camarote.getCategoria().getId());
    ps.setInt(6, camarote.getTipoIngresso().getId());
    ps.setFloat(7, camarote.getValor());
ps = conn.createStatement();
    ps.execute();
    String sql2 = "SELECT CURRVAL('ingresso_id_seq') as  id;";
    Statement sta = con.createStatement();
    ResultSet rs = sta.executeQuery(sql2);
    while (rs.next()) {
        camarote.setId(rs.getInt("id"));
    }
}}

