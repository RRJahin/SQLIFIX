public class Dummy{
public void inserir(Produto pista) throws SQLException {
    Connection con = util.Conexao.getConexao();
    String sql = "INSERT INTO ingresso ( local, datahora, lugar, quantidade, idcategoria, idtipoingresso, valor) " + "VALUES ("+pista.getLocal()+","+new java.sql.Date(pista.getDataHora().getTime())+","+pista.getLugar()+","+pista.getQuantidade()+","+pista.getCategoria().getId()+","+pista.getTipoIngresso().getId()+","+pista.getValor()+")";
    Statement ps = con.createStatement();
    ps.execute(sql);
    String sql2 = "SELECT CURRVAL('ingresso_id_seq') as  id;";
    Statement sta = con.createStatement();
    ResultSet rs = sta.executeQuery(sql2);
    while (rs.next()) {
        pista.setId(rs.getInt("id"));
    }
}}

