public class Dummy{
void afegeixLlibre(int ISBN, String titol, String portada, int numPag, String editorial, int autor) throws SQLException {
    Connection conn = this.conn;
    
    String llibre = "insert into practica7.LLIBRE values (DEFAULT, ?,?,?,?,?,?)";
    PreparedStatement afegeixUsuariStmt = conn.prepareStatement(llibre);
    afegeixUsuariStmt.setObject(1, ISBN );
    afegeixUsuariStmt.setObject(2, titol );
    afegeixUsuariStmt.setObject(3, portada );
    afegeixUsuariStmt.setObject(4, numPag);
    afegeixUsuariStmt.setObject(5, editorial );
    afegeixUsuariStmt.setObject(6, autor );
    afegeixUsuariStmt.executeUpdate();

    String copia  = "insert into practica7.COPIA values (last_insert_id(), NULL)";
    afegeixUsuariStmt = conn.prepareStatement(copia );
    afegeixUsuariStmt.executeUpdate();
}}

