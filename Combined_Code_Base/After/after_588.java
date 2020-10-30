class Dummy{
public void inserir(Produto doisD) throws SQLException {
    Connection con = util.Conexao.getConexao();
    String sql = "INSERT INTO ingresso ( local, datahora, lugar, quantidade, idcategoria, idtipoingresso, valor) " + "VALUES (?,?,?,?,?,?,?)";
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setObject(1, doisD.getLocal());
    ps.setDate(2, new java.sql.Date(doisD.getDataHora().getTime()));
    ps.setObject(3, doisD.getLugar());
    ps.setObject(4, doisD.getQuantidade());
    ps.setObject(5, doisD.getCategoria().getId());
    ps.setObject(6, doisD.getTipoIngresso().getId());
    ps.setObject(7, doisD.getValor());
    ps.execute();
    String sql2 = "SELECT CURRVAL('ingresso_id_seq') as  id;";
PreparedStatement sta = con.prepareStatement();
    ResultSet rs = sta.executeQuery(sql2);
    while (rs.next()) {
        doisD.setId(rs.getInt("id"));
    }
}}

