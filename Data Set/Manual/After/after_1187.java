public class Dummy{
public void delete(Agricultor agricultor) throws Exception {
    String SQL = "DELETE FROM CADASTROAGRICULTOR WHERE ID_AGRICULTOR = ?";
    try {
        PreparedStatement p = connection.prepareStatement(SQL);
        p.setObject(1, agricultor.getId_agricultor());
        p.execute();
    } catch (SQLException ex) {
        throw new Exception(ex);
    }
}}

