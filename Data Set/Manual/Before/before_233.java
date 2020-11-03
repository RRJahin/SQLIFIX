public class Dummy{
@Override
public boolean update(OptionVisite obj) {
    boolean result = false;
    String sql = "UPDATE OptionVisite SET label = "+obj.getLabel()+", niveau = "+obj.getNiveau()+", parent = "+obj.getParent()+", type = "+obj.getType()+", typeB = "+obj.getTypeB()+" WHERE id = "+obj.getId();
    try {
        Statement update = connect.createStatement();
        int rs = update.executeUpdate(sql);
        result = (rs != 0);
    } catch (Exception ex) {
        String message = "Erreur 100 082\nErreur Update base de données\n" + ex.getClass().getName() + "\n" + ex.getMessage();
        MessageDialog.displayError(message);
        ex.printStackTrace();
        System.exit(0);
    }
    return result;
}}

