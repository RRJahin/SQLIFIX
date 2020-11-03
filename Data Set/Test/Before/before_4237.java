class Dummy{
public int atacar(boolean esVillano, String id_round, String id_habilidad) {
    ResultSet rs = null;
    int inserted = 0;
    try {
        Statement stmt = connection.createStatement();
        if (esVillano) {
stmt = connection.createStatement();
            inserted = stmt.executeUpdate("update round set hab_villano=" + id_habilidad + " where id_round=" + id_round);
        } else {
            inserted = stmt.executeUpdate("update round set hab_heroe=" + id_habilidad + " where id_round=" + id_round);
        }
        connection.commit();
        stmt.close();
    } catch (SQLException ex) {
        Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
    }
    return inserted;
}}

