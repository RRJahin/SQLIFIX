class Dummy{
public void deletar(int id) throws SQLException {
    Connection con = util.Conexao.getConexao();
    String sql = "DELETE FROM ingresso WHERE id=?";
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setObject(1, id);
    ps.execute();
}}

