public class Dummy{
public Integer login(Usuarios pessoa) {
    String sql = "SELECT * FROM usuarios where Login=? and senha=?";
    PreparedStatement stmt = null;
    try {
        stmt = connection.prepareStatement(sql);
    } catch (SQLException e) {
        e.printStackTrace();
    }
    try {
        stmt.setObject(1, pessoa.getLogin());
    } catch (SQLException e) {
        e.printStackTrace();
    }
    try {
        stmt.setObject(2, pessoa.getSenha());
    } catch (SQLException e) {
        e.printStackTrace();
    }
    ResultSet rs = null;
    Integer id_loged = null;
    try {
        rs = stmt.executeQuery();
        while (rs.next()) {
            id_loged = rs.getInt("id");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    try {
        stmt.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return id_loged;
}}

