public class Dummy{
public void alterar(Produto meia) throws SQLException {
    Connection con = util.Conexao.getConexao();
    String sql = "UPDATE ingresso SET local=?, datahora=?, lugar=?, quantidade=?, idcategoria=?, idtipoingresso=?, valor=? WHERE id=?";
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setObject(1, meia.getLocal());
    ps.setObject(2, new java.sql.Date(meia.getDataHora().getTime()));
    ps.setObject(3, meia.getLugar());
    ps.setObject(4, meia.getQuantidade());
    ps.setObject(5, meia.getCategoria().getId());
    ps.setObject(6, meia.getTipoIngresso().getId());
    ps.setObject(7, meia.getValor());
    ps.setObject(8, meia.getId());
    ps.executeUpdate();
}}

