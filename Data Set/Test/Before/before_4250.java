class Dummy{
public boolean ganoVillano(String id_bat) {
    try {
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery("select * from batalla where id_batalla=" + id_bat);
        rs.next();
        if (rs.getInt("id_villano") == rs.getInt("id_ganador")) {
            return true;
        }
    } catch (SQLException ex) {
        Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
    }
    return false;
}}

