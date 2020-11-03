class Dummy{
public String nuevoRound(String id_batalla) {
    try {
        ResultSet ultimo = getUltimoRound(id_batalla);
        ultimo.next();
        String id_turno = ultimo.getString("id_turno");
        String Snull = null;
        String numeroRound = String.valueOf(ultimo.getInt("numeroround") + 1);
        String ptsvida_heroe = ultimo.getString("ptsvida_heroe");
        String ptsvida_villano = ultimo.getString("ptsvida_villano");
        Statement stmt = connection.createStatement();
        int inserted = stmt.executeUpdate("insert into round (id_batalla,id_turno,hab_heroe,hab_villano,numeroRound,ptsvida_heroe,ptsvida_villano) values(" + id_batalla + "," + id_turno + "," + Snull + "," + Snull + "," + numeroRound + "," + ptsvida_heroe + "," + ptsvida_villano + ")");
        connection.commit();
        stmt.close();
        if (inserted == 1) {
            return "Ok";
        }
    } catch (SQLException ex) {
        Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
    }
    return "Error al crear Round";
}}

