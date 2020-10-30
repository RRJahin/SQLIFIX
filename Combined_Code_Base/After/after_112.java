public class Dummy{
public void alterar(Produto adulto) throws SQLException {
    Connection con = util.Conexao.getConexao();
    String sql = "UPDATE ingresso SET local=?, datahora=?, lugar=?, quantidade=?, idcategoria=?, idtipoingresso=?, valor=? WHERE id=?";
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setObject(1, adulto.getLocal());
    ps.setObject(2, new java.sql.Date(adulto.getDataHora().getTime()));
    ps.setObject(3, adulto.getLugar());
    ps.setObject(4, adulto.getQuantidade());
    ps.setObject(5, adulto.getCategoria().getId());
    ps.setObject(6, adulto.getTipoIngresso().getId());
    ps.setObject(7, adulto.getValor());
    ps.setObject(8, adulto.getId());
    ps.executeUpdate();
}}

