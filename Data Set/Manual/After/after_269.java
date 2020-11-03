public class Dummy{
@Override
public boolean delete(ParcClient obj) {
    boolean result = false;
    String sql = "DELETE FROM ParcClient WHERE id = ?";
    try {
        PreparedStatement delete = connect.prepareStatement(sql);
        delete.setObject(1, obj.getId());
        int rs = delete.executeUpdate();
        result = (rs != 0);
    } catch (SQLException ex) {
        String message = "Erreur 100 091\nErreur Delete base de données\n" + ex.getClass().getName() + "\n" + ex.getMessage();
        MessageDialog.displayError(message);
        ex.printStackTrace();
        System.exit(0);
    }
    return result;
}}

