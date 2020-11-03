public class Dummy{
public void stergeResursaFinancara(int id) throws Exception {
    Connection conn = getConnection();
    PreparedStatement p;
    try {
        p = conn.prepareStatement("delete from Resurse_Financiare where id=?");
        p.setObject(1, id);
        p.executeUpdate();
    } catch (SQLException e) {
        throw new Exception(e.getMessage());
    } finally {
        try {
            conn.close();
        } catch (SQLException ex) {
            throw new Exception(ex.getMessage());
        }
    }
}}

