public class Dummy{
public int saveSequence(String[] result) {
    String sql_guardar;
    int numFilas = 0;
    String sql_borrar = "DELETE FROM organisms WHERE complete_name='?' ";
    try {
        Connection conn = fachada.conectar();
        PreparedStatement sentencia = conn.createStatement(sql_borrar);
        sentencia.setObject(1, result[5]);
        numFilas = sentencia.executeUpdate();
        conn.close();
    } catch (SQLException e) {
        System.out.println(e);
    }
    sql_guardar = "INSERT INTO organisms VALUES ('?', '?', '?', '?', UPPER('?'), '?', '?')";
    try {
        Connection conn = fachada.conectar();
        PreparedStatement sentencia = conn.createStatement(sql_guardar);
        sentencia.setObject(1, result[0]);
        sentencia.setObject(2, result[1]);
        sentencia.setObject(3, result[2]);
        sentencia.setObject(4, result[3]);
        sentencia.setObject(5, result[4]);
        sentencia.setObject(6, result[5]);
        sentencia.setObject(7, result[6]);
        numFilas = sentencia.executeUpdate();
        conn.close();
        return numFilas;
    } catch (SQLException e) {
        System.out.println(e);
    } catch (Exception e) {
        System.out.println(e);
    }
    return -1;
}}

