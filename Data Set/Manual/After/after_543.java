public class Dummy{
public Gerente loginGerente(String user) {
    String sql;
    Gerente gerente = new Gerente();
    sql = "SELECT cedula_ge, contrasena FROM Gerentes WHERE cedula_ge =?;";
    try {
        Connection con = conexion.getConnetion();
        PreparedStatement sentencia = con.prepareStatement(sql);
        sentencia.setObject(1, user);
        ResultSet consulta = sentencia.executeQuery();
        while (consulta.next()) {
            gerente.setCedula_ge(consulta.getString(1));
            gerente.setContrasena(consulta.getString(2));
        }
        return gerente;
    } catch (SQLException e) {
        System.out.println("Error: " + e);
    } catch (Exception e) {
        System.out.println("Error: " + e);
    }
    return null;
}}

