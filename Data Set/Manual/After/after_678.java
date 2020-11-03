public class Dummy{
public int saveCadruDidactic(CadruDidactic cd) throws SQLException {
    Connection conn = getConnection();
    PreparedStatement p;
    p = conn.prepareStatement("INSERT INTO Cadre_Didactice  VALUES(?,?,?,?,?)");
    p.setObject(1, cd.getPozitia());
    p.setObject(2, cd.getDenumirePost());
    p.setObject(3, cd.getNume());
    p.setObject(4, cd.getFunctia());
    p.setObject(5, cd.getTitVac());
    p.executeUpdate();
    p = conn.prepareStatement("Select Id_Cadru_Didactic from Cadre_Didactice where pozitia=? and den_post=? and nume=? and functia=? and tit_vac=?");
    p.setObject(1, cd.getPozitia());
    p.setObject(2, cd.getDenumirePost());
    p.setObject(3, cd.getNume());
    p.setObject(4, cd.getFunctia());
    p.setObject(5, cd.getTitVac());
    ResultSet rs = p.executeQuery();
    rs.next();
    return rs.getInt(1);
}}

