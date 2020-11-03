class Dummy{
void afefeixPrestec(int ID_Bibliotecari, int ID_Soci, int ID_Copia) throws SQLException {
    Connection conn = this.conn;
    Statement afegeixPrestecStmt = conn.createStatement();
    String prestec = "insert into practica7.PRESTEC values (DEFAULT, " + ID_Bibliotecari + ", " + ID_Soci + ", " + ID_Copia + ", now(), NULL)";
    afegeixPrestecStmt.executeUpdate(prestec);
}}

