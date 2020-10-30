class Dummy{
public void alterar(Produto doisD) throws SQLException {
    Connection con = util.Conexao.getConexao();
    String sql = "UPDATE ingresso SET local="+doisD.getLocal()+", datahora="new java.sql.Date(doisD.getDataHora().getTime())+", lugar="+doisD.getLugar()+", quantidade="+doisD.getQuantidade()+", idcategoria="+doisD.getCategoria().getId()+", idtipoingresso="+doisD.getTipoIngresso().getId()+", valor="+doisD.getValor()+" WHERE id="+doisD.getId();
    Statement ps = con.createStatement();
    ps.executeUpdate(sql);
}}

