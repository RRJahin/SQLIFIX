public class Dummy{
@Override
public boolean update(Agence obj) {
    boolean result = false;
    String sql = "UPDATE Agence SET codeAgence = ?, nomAgence = ? WHERE id = ?";
    try {
        PreparedStatement update = connect.prepareStatement(sql);
        update.setObject(1, obj.getCodeAgence());
        update.setObject(2, obj.getNomAgence());
        update.setObject(3, obj.getId());
        int rs = update.executeUpdate();
        result = (rs != 0) ? true : false;
    } catch (SQLException ex) {
        String message = "Erreur 100 002\nErreur Update base de données\n" + ex.getClass().getName() + "\n" + ex.getMessage();
        MessageDialog.displayError(message);
        ex.printStackTrace();
        System.exit(0);
    }
    return result;
}}

