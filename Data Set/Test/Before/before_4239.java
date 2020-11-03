class Dummy{
public String nuevoRound(String id_batalla, String id_turno, String hab_heroe, String hab_villano, String numeroRound, String ptsvida_heroe, String ptsvida_villano) throws SQLException {
    Statement stmt = connection.createStatement();
    int inserted = stmt.executeUpdate("insert into round (id_batalla,id_turno,hab_heroe,hab_villano,numeroRound,ptsvida_heroe,ptsvida_villano) values(" + id_batalla + "," + id_turno + "," + hab_heroe + "," + hab_villano + "," + numeroRound + "," + ptsvida_heroe + "," + ptsvida_villano + ")");
    connection.commit();
    stmt.close();
    if (inserted == 1) {
        return "Ok";
    }
    return "Error al crear Round";
}}

