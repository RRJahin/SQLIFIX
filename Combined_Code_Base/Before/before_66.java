public class Dummy{
public void inserir(Produto meia) throws SQLException {
    Connection con = util.Conexao.getConexao();
    String sql = "INSERT INTO ingresso ( local, datahora, lugar, quantidade, idcategoria, idtipoingresso, valor) " + "VALUES ("+meia.getLocal()+","+new java.sql.Date(meia.getDataHora().getTime())+"," + meia.getLugar() + "," + meia.getQuantidade())+ "," + meia.getCategoria().getId() + ","+ meia.getTipoIngresso().getId() + "," + meia.getValor()+")";
    Statement ps = con.createStatement();
    ps.executeQuery(sql);
    String sql2 = "SELECT CURRVAL('ingresso_id_seq') as  id;";
    Statement sta = con.createStatement();
    ResultSet rs = sta.executeQuery(sql2);
    while (rs.next()) {
        meia.setId(rs.getInt("id"));
    }
}}

