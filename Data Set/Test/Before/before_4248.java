class Dummy{
public ResultSet getBatalla(String id) {
    ResultSet rs = null;
    try {
        Statement s = connection.createStatement();
        rs = s.executeQuery("select * from batalla where id_batalla=" + id);
    } catch (SQLException ex) {
        Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
    }
    return rs;
}}

