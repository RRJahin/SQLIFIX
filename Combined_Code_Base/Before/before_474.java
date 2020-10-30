public class Dummy{
@Override
public boolean delete(Agence obj) {
    boolean result = false;
    String sql = "DELETE FROM Agence WHERE id = "+obj.getId();
    try {
        Statement delete = connect.createStatement();
        int rs = delete.executeUpdate(sql);
        result = (rs != 0) ? true : false;
    } catch (SQLException ex) {
        String message = "Erreur 100 001\nErreur Delete base de données\n" + ex.getClass().getName() + "\n" + ex.getMessage();
        MessageDialog.displayError(message);
        ex.printStackTrace();
        System.exit(0);
    }
    return result;
}}

