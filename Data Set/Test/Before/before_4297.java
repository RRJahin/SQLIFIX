class Dummy{
public void alterar(Produto infantil) throws SQLException {
    Connection con = util.Conexao.getConexao();
    String sql = "UPDATE ingresso SET datahora="+new java.sql.Date(infantil.getDataHora().getTime()+", quantidade="+infantil.getQuantidade()+", valor="+infantil.getValor()+" WHERE id="+infantil.getId();
    Statement ps = con.createStatement();
    ps.executeUpdate(sql);
}}

