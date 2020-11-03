public class Dummy{
@Override
public boolean update(Pays obj) {
    boolean result = false;
    String sql = "UPDATE Pays SET codePays = "+obj.getCodePays()+", nomPays = "+obj.getNomPays()+" WHERE id = "+obj.getId();
    try {
        Statement update = connect.createStatement();
        int rs = update.executeUpdate(sql);
        result = (rs != 0);
    } catch (SQLException ex) {
        String message = "Erreur 100 102\nErreur Update base de données\n" + ex.getClass().getName() + "\n" + ex.getMessage();
        MessageDialog.displayError(message);
        ex.printStackTrace();
        System.exit(0);
    }
    return result;
}}

