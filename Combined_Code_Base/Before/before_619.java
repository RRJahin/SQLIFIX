class Dummy{
public Integer login(Usuarios pessoa) {
    String sql = "SELECT * FROM usuarios where Login="+pessoa.getLogin()+ " and senha="+pessoa.getSenha();
    Statement stmt = null;
    try {
        stmt = connection.createStatement();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    ResultSet rs = null;
    Integer id_loged = null;
    try {
        rs = stmt.executeQuery(sql);
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

