class Dummy{
public boolean isVillano(String id_maestro) throws SQLException {
    Statement s = connection.createStatement();
    ResultSet rs = s.executeQuery("SELECT tipo FROM maestro WHERE id_maestro=" + id_maestro);
    rs.next();
    int tipo = rs.getInt("tipo");
    if (tipo == 0) {
        return true;
    }
    return false;
}}

