import java.sql.PreparedStatement;

class Dummy{
void afegeixSoci(String DNI, String nom, String llinatge1, String llinatge2, String dataNaixement) throws SQLException {
    Connection conn = this.conn;
    
    String persona = "insert into practica7.PERSONA values (DEFAULT, ?,?,?,?)";
    PreparedStatement afegeixUsuariStmt = conn.prepareStatement(persona);
    afegeixUsuariStmt.setObject(1, nom);
    afegeixUsuariStmt.setObject(2, llinatge1);
    afegeixUsuariStmt.setObject(3, llinatge2);
    afegeixUsuariStmt.setObject(4, dataNaixement);
    afegeixUsuariStmt.executeUpdate();

    String soci = "insert into practica7.SOCI values (LAST_INSERT_ID(),?)";
    afegeixUsuariStmt = conn.prepareStatement(soci);
    afegeixUsuariStmt.setObject(1, DNI);
    afegeixUsuariStmt.executeUpdate();
}}

