public class Dummy{
public int saveSequence(String[] result) {
    String sql_guardar;
    int numFilas = 0;
    String sql_borrar = "DELETE FROM organisms WHERE complete_name='" + result[5] + "' ";
    try {
        Connection conn = fachada.conectar();
        Statement sentencia = conn.createStatement();
        numFilas = sentencia.executeUpdate(sql_borrar);
        conn.close();
    } catch (SQLException e) {
        System.out.println(e);
    }
    sql_guardar = "INSERT INTO organisms VALUES ('" + result[0] + "', '" + result[1] + "', '" + result[2] + "', '" + result[3] + "', UPPER('" + result[4] + "'), '" + result[5] + "', '" + result[6] + "')";
    try {
        Connection conn = fachada.conectar();
        Statement sentencia = conn.createStatement();
        numFilas = sentencia.executeUpdate(sql_guardar);
        conn.close();
        return numFilas;
    } catch (SQLException e) {
        System.out.println(e);
    } catch (Exception e) {
        System.out.println(e);
    }
    return -1;
}}

