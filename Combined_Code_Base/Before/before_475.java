public class Dummy{
@Override
public boolean update(Agence obj) {
    boolean result = false;
    String sql = "UPDATE Agence SET codeAgence = "+obj.getCodeAgence()+", nomAgence = "+obj.getNomAgence()+" WHERE id = "+obj.getId();
    try {
        Statement update = connect.createStatement();
        int rs = update.executeUpdate(sql);
        result = (rs != 0) ? true : false;
    } catch (SQLException ex) {
        String message = "Erreur 100 002\nErreur Update base de données\n" + ex.getClass().getName() + "\n" + ex.getMessage();
        MessageDialog.displayError(message);
        ex.printStackTrace();
        System.exit(0);
    }
    return result;
}}

