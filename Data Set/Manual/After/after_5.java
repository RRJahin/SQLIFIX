public class Dummy{
public void stergeCadruDidactic(int id_Cadru_Didactic) throws SQLException {
    Connection conn = getConnection();
    PreparedStatement p;
    p = conn.prepareStatement("Delete from Cadre_Didactice where id_Cadru_Didactic = ?");
    p.setObject(1, id_Cadru_Didactic);
    p.executeUpdate();
}}

