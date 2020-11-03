public class Dummy{
public void modificaCadruDidactic(CadruDidactic cd) throws SQLException {
    Connection conn = getConnection();
    PreparedStatement p;
    p = conn.prepareStatement("UPDATE Cadre_Didactice  SET " + "pozitia = ?, " + "den_post = ?, " + "nume = ?, " + "functia= ?, " + "tit_vac = ? " + "WHERE Id_Cadru_Didactic= ?");
    p.setObject(1, cd.getPozitia());
    p.setObject(2, cd.getDenumirePost());
    p.setObject(3, cd.getNume());
    p.setObject(4, cd.getFunctia());
    p.setObject(5, cd.getTitVac());
    p.setObject(6, cd.getId());
    p.executeUpdate();
}}

