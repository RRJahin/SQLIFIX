public class Dummy{
@Override
public boolean create(OptionVisite obj) {
    boolean result = false;
    String sql = "INSERT INTO OptionVisite (id, label, niveau, parent, type, typeB) VALUES ("+obj.getId()+", "+obj.getLabel()+", "+obj.getNiveau()+", "+obj.getParent()+", "+obj.getType()+", "+obj.getTypeB()+")";
    try {
        Statement insert = connect.createStatement();
        int rs = insert.executeUpdate(sql);
        result = (rs != 0);
    } catch (SQLException ex) {
        String message = "Erreur 100 080\nErreur Insert base de données\n" + ex.getClass().getName() + "\n" + ex.getMessage();
        MessageDialog.displayError(message);
        ex.printStackTrace();
        System.exit(0);
    }
    return result;
}}

