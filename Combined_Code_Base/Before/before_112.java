public class Dummy{
public void alterar(Produto adulto) throws SQLException {
    Connection con = util.Conexao.getConexao();
    String sql = "UPDATE ingresso SET local="+adulto.getLocal()+", datahora="+new java.sql.Date(adulto.getDataHora().getTime())+", lugar="+adulto.getLugar()+", quantidade="+adulto.getQuantidade()+", idcategoria="+adulto.getCategoria().getId()+", idtipoingresso="+adulto.getTipoIngresso().getId()+", valor="+adulto.getValor()+" WHERE id="+adulto.getId();
    Statement ps = con.createStatement();
    ps.executeUpdate(sql);
}}

