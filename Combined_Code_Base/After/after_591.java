class Dummy{
public Produto visualizarUm(int codigo) throws SQLException {
    Connection con = util.Conexao.getConexao();
    String sql = "SELECT * FROM ingresso WHERE id=?";
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setObject(1, codigo);
    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
        return new DoisD(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getInt(5), categoria.visualizarUm(rs.getInt(6)), tipoIngresso.visualizarUm(rs.getInt(7)), rs.getFloat(8));
    }
    return null;
}}

