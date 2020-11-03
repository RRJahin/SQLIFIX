class Dummy{
public void inserir(Produto vip) throws SQLException {
    Connection con = util.Conexao.getConexao();
    String sql = "INSERT INTO ingresso ( local, datahora, lugar, quantidade, idcategoria, idtipoingresso, valor) " + "VALUES (?,?,?,?,?,?,?)";
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setString(1, vip.getLocal());
    ps.setDate(2, new java.sql.Date(vip.getDataHora().getTime()));
    ps.setString(3, vip.getLugar());
    ps.setInt(4, vip.getQuantidade());
    ps.setInt(5, vip.getCategoria().getId());
    ps.setInt(6, vip.getTipoIngresso().getId());
    ps.setFloat(7, vip.getValor());
ps = con.createStatement();
    ps.execute();
    String sql2 = "SELECT CURRVAL('ingresso_id_seq') as  id;";
    Statement sta = con.createStatement();
    ResultSet rs = sta.executeQuery(sql2);
    while (rs.next()) {
        vip.setId(rs.getInt("id"));
    }
    System.out.println("Salvo com Sucesso!");
}}

