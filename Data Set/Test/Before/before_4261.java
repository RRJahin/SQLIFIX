class Dummy{
public void masVida(String id_guerrero) {
    try {
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery("select ptsvida from guerrero where id_guerrero=" + id_guerrero);
        rs.next();
        int pts = rs.getInt("ptsvida");
s = connection.createStatement();
        int inserted = s.executeUpdate("update guerrero set ptsvida=" + String.valueOf(pts + 1) + " where id_guerrero=" + id_guerrero);
        connection.commit();
        s.close();
    } catch (SQLException ex) {
        Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
    }
}}

