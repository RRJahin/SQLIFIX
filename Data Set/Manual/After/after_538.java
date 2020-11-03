public class Dummy{
public void altera(Usuarios pessoa) {
    String sql = "UPDATE Usuarios SET " + "nome=?,login=?, senha=?, email=? WHERE id=?";
    PreparedStatement stmt = null;
    try {
        stmt = connection.prepareStatement(sql);
    } catch (SQLException e) {
        e.printStackTrace();
    }
    try {
        stmt.setObject(1, pessoa.getNome());
    } catch (SQLException e) {
        e.printStackTrace();
    }
    try {
        stmt.setObject(2, pessoa.getLogin());
    } catch (SQLException e) {
        e.printStackTrace();
    }
    try {
        stmt.setObject(3, pessoa.getSenha());
    } catch (SQLException e) {
        e.printStackTrace();
    }
    try {
        stmt.setObject(4, pessoa.getEmail());
    } catch (SQLException e) {
        e.printStackTrace();
    }
    try {
        stmt.setObject(5, pessoa.getId());
    } catch (SQLException e) {
        e.printStackTrace();
    }
    try {
        stmt.execute();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    try {
        stmt.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}}

