public class Dummy{
public void alterar(Produto pista) throws SQLException {
    Connection con = util.Conexao.getConexao();
    String sql = "UPDATE ingresso SET local=?, datahora=?, lugar=?, quantidade=?, idcategoria=?, idtipoingresso=?, valor=? WHERE id=?";
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setObject(1, pista.getLocal());
    ps.setObject(2, new java.sql.Date(pista.getDataHora().getTime()));
    ps.setObject(3, pista.getLugar());
    ps.setObject(4, pista.getQuantidade());
    ps.setObject(5, pista.getCategoria().getId());
    ps.setObject(6, pista.getTipoIngresso().getId());
    ps.setObject(7, pista.getValor());
    ps.setObject(8, pista.getId());
    ps.executeUpdate();
}}

