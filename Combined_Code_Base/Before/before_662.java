class Dummy{
String[] rebBibliotecari(int ID) throws SQLException {
    String[] dadesBibliotecari = new String[5];
    Connection conn = this.conn;
    Statement rebBibliotecariStmt = conn.createStatement();
    String persona = "select * from practica7.PERSONA where ID = " + ID + ";";
    ResultSet rs = rebBibliotecariStmt.executeQuery(persona);
    while (rs.next()) {
        dadesBibliotecari[0] = rs.getString("Nom");
        dadesBibliotecari[1] = rs.getString("Llinatge1");
        dadesBibliotecari[2] = rs.getString("Llinatge2");
        dadesBibliotecari[3] = rs.getString("Data_Naixement");
    }
    rs.close();
    String bibliotecari = "select * from practica7.BIBLIOTECARI where ID = " + ID + ";";
    ResultSet rs2 = rebBibliotecariStmt.executeQuery(bibliotecari);
    while (rs2.next()) {
        dadesBibliotecari[4] = rs2.getString("DNI");
    }
    rs2.close();
    return dadesBibliotecari;
}}

