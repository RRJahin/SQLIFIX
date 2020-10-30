class Dummy{
public void inserir(Produto doisD) throws SQLException {
    Connection con = util.Conexao.getConexao();
    String sql = "INSERT INTO ingresso ( local, datahora, lugar, quantidade, idcategoria, idtipoingresso, valor) " + 
    "VALUES ("+doisD.getLocal()+","+new java.sql.Date(doisD.getDataHora().getTime())+","+doisD.getLugar()+
    ","+doisD.getQuantidade()+","+doisD.getCategoria().getId()+","+doisD.getTipoIngresso().getId()+","+doisD.getValor()+")";
    Statement ps = con.createStatement();
    ps.execute(sql);
    String sql2 = "SELECT CURRVAL('ingresso_id_seq') as  id;";
    Statement sta = con.createStatement();
    ResultSet rs = sta.executeQuery(sql2);
    while (rs.next()) {
        doisD.setId(rs.getInt("id"));
    }
}}

