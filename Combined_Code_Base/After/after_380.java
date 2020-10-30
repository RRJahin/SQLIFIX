public class Dummy{
public void inserir(Produto pista) throws SQLException {
    Connection con = util.Conexao.getConexao();
    String sql = "INSERT INTO ingresso ( local, datahora, lugar, quantidade, idcategoria, idtipoingresso, valor) " + "VALUES (?,?,?,?,?,?,?)";
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setObject(1, pista.getLocal());
    ps.setObject(2, new java.sql.Date(pista.getDataHora().getTime()));
    ps.setObject(3, pista.getLugar());
    ps.setObject(4, pista.getQuantidade());
    ps.setObject(5, pista.getCategoria().getId());
    ps.setObject(6, pista.getTipoIngresso().getId());
    ps.setObject(7, pista.getValor());
    ps.execute();
    String sql2 = "SELECT CURRVAL('ingresso_id_seq') as  id;";
    PreparedStatement sta = con.prepareStatement();
    ResultSet rs = sta.executeQuery(sql2);
    while (rs.next()) {
        pista.setId(rs.getInt("id"));
    }
}}

