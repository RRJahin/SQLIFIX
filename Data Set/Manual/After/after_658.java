class Dummy{
void afegeixAutor(String nacionalitat, String alies, String nom, String llinatge1, String llinatge2, String dataNaixement) throws SQLException {
    Connection conn = this.conn;
    
    String persona = "insert into practica7.PERSONA values (DEFAULT, ?,?,?,?)";
    PreparedStatement afegeixUsuariStmt = conn.prepareStatement(persona);
    afegeixUsuariStmt.setObject(1, nom);
    afegeixUsuariStmt.setObject(2, llinatge1);
    afegeixUsuariStmt.setObject(3, llinatge2);
    afegeixUsuariStmt.setObject(4, dataNaixement);
    afegeixUsuariStmt.executeUpdate();

    String autor = "insert into practica7.AUTOR values (LAST_INSERT_ID(),?)";
    afegeixUsuariStmt = conn.prepareStatement(autor);
    afegeixUsuariStmt.setObject(1, nacionalitat);
    afegeixUsuariStmt.setObject(2,alies);
    afegeixUsuariStmt.executeUpdate();
}}

