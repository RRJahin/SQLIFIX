class Dummy{
public void inserir(Produto infantil) throws SQLException {
    Connection con = util.Conexao.getConexao();
    String sql = "INSERT INTO ingresso ( local, datahora, lugar, quantidade) " + 
    "VALUES ("+infantil.getLocal()+","+new java.sql.Date(infantil.getDataHora().getTime())+","+infantil.getLugar()+","+infantil.getQuantidade()+")";
    Statement ps = con.createStatement();
    ps.execute(sql);

}}

