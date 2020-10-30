public class Dummy{
public Administrador loginAdministrador(String user) {
    String sql;
    Administrador administrador = new Administrador();
    sql = "SELECT usuario, contrasena FROM Administradores WHERE usuario = '" + user + "';";
    try {
        Connection con = conexion.getConnetion();
        Statement sentencia = con.createStatement();
        ResultSet consulta = sentencia.executeQuery(sql);
        while (consulta.next()) {
            administrador.setUsuario(consulta.getString(1));
            administrador.setContrasena(consulta.getString(2));
        }
        return administrador;
    } catch (SQLException e) {
        System.out.println("Error: " + e);
    } catch (Exception e) {
        System.out.println("Error: " + e);
    }
    return null;
}}

