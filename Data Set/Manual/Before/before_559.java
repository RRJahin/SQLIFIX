public class Dummy{
String[] rebSoci(int ID) throws SQLException {
    String[] dadesSoci = new String[5];
    Connection conn = this.conn;
    Statement rebSociStmt = conn.createStatement();
    String persona = "select * from practica7.PERSONA where ID = " + ID + ";";
    ResultSet rs = rebSociStmt.executeQuery(persona);
    while (rs.next()) {
        dadesSoci[0] = rs.getString("Nom");
        dadesSoci[1] = rs.getString("Llinatge1");
        dadesSoci[2] = rs.getString("Llinatge2");
        dadesSoci[3] = rs.getString("Data_Naixement");
    }
    rs.close();
    String soci = "select * from practica7.SOCI where ID = " + ID + ";";
    ResultSet rs2 = rebSociStmt.executeQuery(soci);
    while (rs2.next()) {
        dadesSoci[4] = rs2.getString("DNI");
    }
    rs2.close();
    return dadesSoci;
}}

