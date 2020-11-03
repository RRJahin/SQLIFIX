public class Dummy{
public void delete(Agricultor agricultor) throws Exception {
    String SQL = "DELETE FROM CADASTROAGRICULTOR WHERE ID_AGRICULTOR = "+agricultor.getId_agricultor();
    try {
        Statement p = connection.createStatement();
        p.execute(SQL);
    } catch (SQLException ex) {
        throw new Exception(ex);
    }
}}

