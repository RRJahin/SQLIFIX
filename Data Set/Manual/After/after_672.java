public class Dummy{
private void saveAlteActivitati(AlteActivitati alteActivitati) throws SQLException {
    Connection conn = getConnection();
    PreparedStatement p = conn.prepareStatement("Insert into Alte_Activitati_CD values(?,?,?,?,?,?,?,?,?,?)");
    p.setObject(1, alteActivitati.getId_Cadru_Didactic());
    p.setObject(2, alteActivitati.getPregAdmitere());
    p.setObject(3, alteActivitati.getComisiiAbsolvire());
    p.setObject(4, alteActivitati.getConsultatii());
    p.setObject(5, alteActivitati.getExamene());
    p.setObject(6, alteActivitati.getIndrLucrDisert());
    p.setObject(7, alteActivitati.getIndrLucrLic());
    p.setObject(8, alteActivitati.getIndrProiect());
    p.setObject(9, alteActivitati.getLucrControl());
    p.setObject(10, alteActivitati.getSeminariiCerc());
    p.executeUpdate();
}}

