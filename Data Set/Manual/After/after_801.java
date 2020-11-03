public class Dummy{
@Override
public boolean create(ModRgl obj) {
    boolean result = false;
    String sql = "INSERT INTO ModRgl (codeModRgl, nomModRgl) VALUES (?, ?)";
    try {
        PreparedStatement insert = connect.prepareStatement(sql);
        insert.setObject(1, obj.getCodeModRgl());
        insert.setObject(2, obj.getNomModRgl());
        int rs = insert.executeUpdate();
        result = (rs != 0);
    } catch (SQLException ex) {
        String message = "Erreur 100 070\nErreur Insert base de données\n" + ex.getClass().getName() + "\n" + ex.getMessage();
        MessageDialog.displayError(message);
        ex.printStackTrace();
        System.exit(0);
    }
    return result;
}}

