class Dummy{
public void alterar(Produto doisD) throws SQLException {
    Connection con = util.Conexao.getConexao();
    String sql = "UPDATE ingresso SET local=?, datahora=?, lugar=?, quantidade=?, idcategoria=?, idtipoingresso=?, valor=? WHERE id=?";
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setObject(1, doisD.getLocal());
    ps.setDate(2, new java.sql.Date(doisD.getDataHora().getTime()));
    ps.setObject(3, doisD.getLugar());
    ps.setObject(4, doisD.getQuantidade());
    ps.setObject(5, doisD.getCategoria().getId());
    ps.setObject(6, doisD.getTipoIngresso().getId());
    ps.setObject(7, doisD.getValor());
    ps.setObject(8, doisD.getId());
    ps.executeUpdate();
}}

