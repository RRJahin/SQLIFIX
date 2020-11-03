public class Dummy{
public void inserir(Produto meia) throws SQLException {
    Connection con = util.Conexao.getConexao();
    String sql = "INSERT INTO ingresso ( local, datahora, lugar, quantidade, idcategoria, idtipoingresso, valor) " + "VALUES (?,?,?,?,?,?,?)";
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setObject(1, meia.getLocal());
    ps.setObject(2, new java.sql.Date(meia.getDataHora().getTime()));
    ps.setObject(3, meia.getLugar());
    ps.setObject(4, meia.getQuantidade());
    ps.setObject(5, meia.getCategoria().getId());
    ps.setObject(6, meia.getTipoIngresso().getId());
    ps.setObject(7, meia.getValor());
    ps.execute();
    String sql2 = "SELECT CURRVAL('ingresso_id_seq') as  id;";
    Statement sta = con.createStatement();
    ResultSet rs = sta.executeQuery(sql2);
    while (rs.next()) {
        meia.setId(rs.getInt("id"));
    }
}}

