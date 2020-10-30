import java.sql.PreparedStatement;

public class Dummy{
void afefeixPrestec(int ID_Bibliotecari, int ID_Soci, int ID_Copia) throws SQLException {
    Connection conn = this.conn;
    String prestec = "insert into practica7.PRESTEC values (DEFAULT, ?,?,?, now(), NULL)";
    PreparedStatement afegeixPrestecStmt = conn.prepareStatement(prestec);
    afegeixPrestecStmt.setObject(1, ID_Bibliotecari);
    afegeixPrestecStmt.setObject(2, ID_Soci);
    afegeixPrestecStmt.setObject(3, ID_Copia);
    afegeixPrestecStmt.executeUpdate();
}}

