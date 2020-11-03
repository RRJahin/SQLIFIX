class Dummy{
public void remove(Integer id) {
    Statement stmt = null;
    try {
        stmt = connection.createStatement();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    try {
        stmt.execute("DELETE FROM Notas WHERE id="+id);
    } catch (SQLException e) {
        e.printStackTrace();
    }
    try {
        stmt.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}}

