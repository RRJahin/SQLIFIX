public class Dummy{
@Override
public boolean create(ModRgl obj) {
    boolean result = false;
    String sql = "INSERT INTO ModRgl (codeModRgl, nomModRgl) VALUES ("+obj.getCodeModRgl()+", "+obj.getNomModRgl()+")";
    try {
        Statement insert = connect.createStatement();
        int rs = insert.executeUpdate(sql);
        result = (rs != 0);
    } catch (SQLException ex) {
        String message = "Erreur 100 070\nErreur Insert base de données\n" + ex.getClass().getName() + "\n" + ex.getMessage();
        MessageDialog.displayError(message);
        ex.printStackTrace();
        System.exit(0);
    }
    return result;
}}

