public class Dummy{
@Override
public boolean delete(ParcClient obj) {
    boolean result = false;
    String sql = "DELETE FROM ParcClient WHERE id = "+obj.getId();
    try {
        Statement delete = connect.createStatement();
        int rs = delete.executeUpdate(sql);
        result = (rs != 0);
    } catch (SQLException ex) {
        String message = "Erreur 100 091\nErreur Delete base de données\n" + ex.getClass().getName() + "\n" + ex.getMessage();
        MessageDialog.displayError(message);
        ex.printStackTrace();
        System.exit(0);
    }
    return result;
}}

