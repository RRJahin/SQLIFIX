class Dummy{
public ResultSet batallasActuales(String user_id) throws SQLException {
    Statement s = connection.createStatement();
    ResultSet rs = null;
    if (isVillano(user_id)) {
s = connection.createStatement();
        rs = s.executeQuery("select b.id_batalla id_batalla, b.nombreBatalla nombreBatalla from batalla b inner join guerrero g on g.id_guerrero = b.id_villano where b.id_ganador is null and g.id_maestro = " + user_id);
    } else {
        rs = s.executeQuery("select b.id_batalla id_batalla, b.nombreBatalla nombreBatalla from batalla b inner join guerrero g on g.id_guerrero = b.id_heroe where b.id_ganador is null and g.id_maestro = " + user_id);
    }
    return rs;
}}

