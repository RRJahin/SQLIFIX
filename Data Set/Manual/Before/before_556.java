public class Dummy{
void afegeixLlibre(int ISBN, String titol, String portada, int numPag, String editorial, int autor) throws SQLException {
    Connection conn = this.conn;
    Statement afegeixLlibreStmt = conn.createStatement();
    String llibre = "insert into practica7.LLIBRE values (DEFAULT, " + ISBN + ",'" + titol + "','" + portada + "'," + numPag + ",'" + editorial + "'," + autor + ")";
    String copia = "insert into practica7.COPIA values (last_insert_id(), NULL)";
    afegeixLlibreStmt.executeUpdate(llibre);
    afegeixLlibreStmt.executeUpdate(copia);
}}

