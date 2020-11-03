public class Dummy{
public void alterar(Produto meia) throws SQLException {
    Connection con = util.Conexao.getConexao();
    String sql = "UPDATE ingresso SET local="+meia.getLocal()+", datahora="+new java.sql.Date(meia.getDataHora().getTime())+", lugar="+meia.getLugar()+", quantidade="+meia.getQuantidade()+", idcategoria="+meia.getCategoria().getId()+", idtipoingresso="+meia.getTipoIngresso().getId()+", valor="+meia.getValor()+" WHERE id="+meia.getId();
    Statement ps = con.createStatement();
    ps.executeUpdate(sql);
}}

