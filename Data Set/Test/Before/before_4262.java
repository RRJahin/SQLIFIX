class Dummy{
public void masPtsFuerza(String id_hab) {
    try {
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery("select ptsfuerza from habilidad where id_habilidad=" + id_hab);
        rs.next();
        int pts = rs.getInt("ptsfuerza");
s = connection.createStatement();
        int inserted = s.executeUpdate("update habilidad set ptsfuerza=" + String.valueOf(pts + 1) + " where id_habilidad=" + id_hab);
        connection.commit();
        s.close();
    } catch (SQLException ex) {
        Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
    }
}}

