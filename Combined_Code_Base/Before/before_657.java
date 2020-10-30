class Dummy{
void afegeixSoci(String DNI, String nom, String llinatge1, String llinatge2, String dataNaixement) throws SQLException {
    Connection conn = this.conn;
    Statement afegeixUsuariStmt = conn.createStatement();
    String persona = "insert into practica7.PERSONA values (DEFAULT, '" + nom + "','" + llinatge1 + "','" + llinatge2 + "','" + dataNaixement + "')";
    String soci = "insert into practica7.SOCI values (LAST_INSERT_ID(), '" + DNI + "')";
    afegeixUsuariStmt.executeUpdate(persona);
    afegeixUsuariStmt.executeUpdate(soci);
}}

