public class Dummy{
@Override
public boolean create(Agence obj) {
    boolean result = false;
    String sql = "INSERT INTO Agence (codeAgence, nomAgence) VALUES ("+obj.getCodeAgence()+", "+obj.getNomAgence()+")";
    try {
        Statement insert = connect.createStatement();
        int rs = insert.executeUpdate(sql);
        result = (rs != 0) ? true : false;
    } catch (SQLException ex) {
        String message = "Erreur 100 000\nErreur Insert base de données\n" + ex.getClass().getName() + "\n" + ex.getMessage();
        MessageDialog.displayError(message);
        ex.printStackTrace();
        System.exit(0);
    }
    return result;
}}

