public class Dummy{
@Override
public boolean update(OptionVisite obj) {
    boolean result = false;
    String sql = "UPDATE OptionVisite SET label = ?, niveau = ?, parent = ?, type = ?, typeB = ? WHERE id = ?";
    try {
        PreparedStatement update = connect.prepareStatement(sql);
        update.setObject(1, obj.getLabel());
        update.setObject(2, obj.getNiveau());
        update.setObject(3, obj.getParent());
        update.setObject(4, obj.getType());
        update.setObject(5, obj.getTypeB());
        update.setObject(6, obj.getId());
        int rs = update.executeUpdate();
        result = (rs != 0);
    } catch (Exception ex) {
        String message = "Erreur 100 082\nErreur Update base de données\n" + ex.getClass().getName() + "\n" + ex.getMessage();
        MessageDialog.displayError(message);
        ex.printStackTrace();
        System.exit(0);
    }
    return result;
}}

