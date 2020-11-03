public class Dummy{
public void inserir(Produto adulto) throws SQLException {
    Connection con = util.Conexao.getConexao();
    String sql = "INSERT INTO ingresso ( local, datahora, lugar, quantidade, idcategoria, idtipoingresso, valor) " + "VALUES (?,?,?,?,?,?,?)";
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setObject(1, adulto.getLocal());
    ps.setObject(2, new java.sql.Date(adulto.getDataHora().getTime()));
    ps.setObject(3, adulto.getLugar());
    ps.setObject(4, adulto.getQuantidade());
    ps.setObject(5, adulto.getCategoria().getId());
    ps.setObject(6, adulto.getTipoIngresso().getId());
    ps.setObject(7, adulto.getValor());
    ps.execute();
    String sql2 = "SELECT CURRVAL('ingresso_id_seq') as  id;";
    Statement sta = con.createStatement();
    ResultSet rs = sta.executeQuery(sql2);
    while (rs.next()) {
        adulto.setId(rs.getInt("id"));
    }
}}

