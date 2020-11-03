public class Dummy{
public void alterar(Produto pista) throws SQLException {
    Connection con = util.Conexao.getConexao();
    String sql = "UPDATE ingresso SET local="+pista.getLocal()+", datahora="+new java.sql.Date(pista.getDataHora().getTime())+", lugar="+pista.getLugar()+", quantidade="+pista.getQuantidade()+", idcategoria="+pista.getCategoria().getId()+", idtipoingresso="+pista.getTipoIngresso().getId()+", valor="+pista.getValor()+" WHERE id="+pista.getId();
    Statement ps = con.createStatement();
    ps.executeUpdate(sql);
}}

