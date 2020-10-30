public class Dummy{
public void inserir(Produto adulto) throws SQLException {
    Connection con = util.Conexao.getConexao();
    String sql = "INSERT INTO ingresso ( local, datahora, lugar, quantidade, idcategoria, idtipoingresso, valor) " + "VALUES ("+adulto.getLocal()+","+new java.sql.Date(adulto.getDataHora().getTime())+","+adulto.getLugar()+","+adulto.getQuantidade()+","+adulto.getCategoria().getId()+","+adulto.getTipoIngresso().getId()+","+adulto.getValor()+")";
    Statement ps = con.createStatement();
    ps.execute(sql);
    String sql2 = "SELECT CURRVAL('ingresso_id_seq') as  id;";
    Statement sta = con.createStatement();
    ResultSet rs = sta.executeQuery(sql2);
    while (rs.next()) {
        adulto.setId(rs.getInt("id"));
    }
}}

