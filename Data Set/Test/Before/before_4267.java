class Dummy{
public void inserir(Produto infantil) throws SQLException {
    Connection con = util.Conexao.getConexao();
    String sql = "INSERT INTO ingresso ( local, datahora, lugar, quantidade, idcategoria) " + 
    "VALUES ("+infantil.getLocal()+","+new java.sql.Date(infantil.getDataHora().getTime())+","+infantil.getLugar()+","+infantil.getQuantidade()+","+infantil.getCategoria().getId()+")";
    Statement ps = con.createStatement();
    ps.execute(sql);

}}

