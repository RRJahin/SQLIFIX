public class Dummy{
private void saveOrar(Orar orar) throws SQLException {
    Connection conn = getConnection();
    PreparedStatement p = conn.prepareStatement("Insert into orar values(?,?,?,?,?,?,?,?,?)");
    p.setObject(1, orar.getZiua());
    p.setObject(2, orar.getOra_inceput());
    p.setObject(3, orar.getOra_sfarsit());
    p.setObject(4, orar.getFrecventa());
    p.setObject(5, orar.getId_Disciplina());
    p.setObject(6, orar.getTip());
    p.setObject(7, orar.getId_Cadru_Didactic());
    p.setObject(8, orar.getId_Sala());
    p.setObject(9, orar.getId_Formatie());
    p.executeUpdate();
}}

