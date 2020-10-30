import java.sql.PreparedStatement;

class Dummy{
String[] rebSoci(int ID) throws SQLException {
    String[] dadesSoci = new String[5];
    Connection conn = this.conn;
    String persona = "select * from practica7.PERSONA where ID = ?;";
    PreparedStatement rebSociStmt = conn.prepareStatement(persona);
    rebSociStmt.setObject(1, ID);
    ResultSet rs = rebSociStmt.executeQuery();
    while (rs.next()) {
        dadesSoci[0] = rs.getString("Nom");
        dadesSoci[1] = rs.getString("Llinatge1");
        dadesSoci[2] = rs.getString("Llinatge2");
        dadesSoci[3] = rs.getString("Data_Naixement");
    }
    rs.close();
    String soci = "select * from practica7.SOCI where ID = ?;";
    rebSociStmt = conn.prepareStatement(soci);
    rebSociStmt.setObject(1, ID);
    ResultSet rs2 = rebSociStmt.executeQuery();
    while (rs2.next()) {
        dadesSoci[4] = rs2.getString("DNI");
    }
    rs2.close();
    return dadesSoci;
}}

