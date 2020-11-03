public class Dummy{
public void remove(Integer id) {
    PreparedStatement stmt = null;
    try {
        stmt = connection.prepareStatement("DELETE FROM Usuarios WHERE id=?");
    } catch (SQLException e) {
        e.printStackTrace();
    }
    try {
        stmt.setObject(1, id);
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

