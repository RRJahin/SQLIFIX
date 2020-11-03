class Dummy{
public void menosPremio(String id_maestro) {
    try {
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery("select premiosrestantes from maestro where id_maestro=" + id_maestro);
        rs.next();
        int pts = rs.getInt("premiosrestantes");
s = connection.createStatement();
        int inserted = s.executeUpdate("update maestro set premiosrestantes=" + String.valueOf(pts - 1) + " where id_maestro=" + id_maestro);
        connection.commit();
        s.close();
    } catch (SQLException ex) {
        Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
    }
}}

