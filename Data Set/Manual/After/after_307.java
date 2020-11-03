public class Dummy{
@Override
public boolean create(Pays obj) {
    boolean result = false;
    String sql = "INSERT INTO Pays (codePays, nomPays) VALUES (?, ?)";
    try {
        PreparedStatement insert = connect.prepareStatement(sql);
        insert.setObject(1, obj.getCodePays());
        insert.setObject(2, obj.getNomPays());
        int rs = insert.executeUpdate();
        result = (rs != 0);
    } catch (SQLException ex) {
        String message = "Erreur 100 100\nErreur Insert base de données\n" + ex.getClass().getName() + "\n" + ex.getMessage();
        MessageDialog.displayError(message);
        ex.printStackTrace();
        System.exit(0);
    }
    return result;
}}

