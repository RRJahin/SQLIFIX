class Dummy{
public ResultSet getUltimoRound(String id_batalla) {
    ResultSet rs = null;
    try {
        Statement s = connection.createStatement();
        rs = s.executeQuery("select * from round where id_batalla=" + id_batalla + " order by numeroRound desc");
    } catch (SQLException ex) {
        Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
    }
    return rs;
}}

