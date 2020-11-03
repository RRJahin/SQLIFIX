public class Dummy{
@Override
public boolean update(Pays obj) {
    boolean result = false;
    String sql = "UPDATE Pays SET codePays = ?, nomPays = ? WHERE id = ?";
    try {
        PreparedStatement update = connect.prepareStatement(sql);
        update.setObject(1, obj.getCodePays());
        update.setObject(2, obj.getNomPays());
        update.setObject(6, obj.getId());
        int rs = update.executeUpdate();
        result = (rs != 0);
    } catch (SQLException ex) {
        String message = "Erreur 100 102\nErreur Update base de données\n" + ex.getClass().getName() + "\n" + ex.getMessage();
        MessageDialog.displayError(message);
        ex.printStackTrace();
        System.exit(0);
    }
    return result;
}}

