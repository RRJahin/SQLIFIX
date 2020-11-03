class Dummy{
public ResultSet todosAtaques(String id_maestro) {
    ResultSet rs = null;
    try {
        Statement s = connection.createStatement();
        rs = s.executeQuery("select h.id_habilidad id, h.nombre h_nombre, g.nombre g_nombre from guerrero g inner join habilidad h on g.id_guerrero = h.id_guerrero where h.ptsfuerza < 10 and g.ptsvida > 0 and h.tipo = 1 and g.id_maestro=" + id_maestro);
    } catch (SQLException ex) {
        Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
    }
    return rs;
}}

