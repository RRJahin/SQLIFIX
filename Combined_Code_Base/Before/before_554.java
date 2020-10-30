public class Dummy{
void afegeixAutor(String nacionalitat, String alies, String nom, String llinatge1, String llinatge2, String dataNaixement) throws SQLException {
    Connection conn = this.conn;
    Statement afegeixAutorStmt = conn.createStatement();
    String persona = "insert into practica7.PERSONA values (DEFAULT, '" + nom + "','" + llinatge1 + "','" + llinatge2 + "','" + dataNaixement + "')";
    String autor = "insert into practica7.AUTOR values (LAST_INSERT_ID(), '" + nacionalitat + "',' " + alies + "')";
    afegeixAutorStmt.executeUpdate(persona);
    afegeixAutorStmt.executeUpdate(autor);
}}

