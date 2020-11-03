public class Dummy{
@Override
public boolean create(OptionVisite obj) {
    boolean result = false;
    String sql = "INSERT INTO OptionVisite (id, label, niveau, parent, type, typeB) VALUES (?, ?, ?, ?, ?, ?)";
    try {
        PreparedStatement insert = connect.prepareStatement(sql);
        insert.setObject(1, obj.getId());
        insert.setObject(2, obj.getLabel());
        insert.setObject(3, obj.getNiveau());
        insert.setObject(4, obj.getParent());
        insert.setObject(5, obj.getType());
        insert.setObject(6, obj.getTypeB());
        int rs = insert.executeUpdate();
        result = (rs != 0);
    } catch (SQLException ex) {
        String message = "Erreur 100 080\nErreur Insert base de données\n" + ex.getClass().getName() + "\n" + ex.getMessage();
        MessageDialog.displayError(message);
        ex.printStackTrace();
        System.exit(0);
    }
    return result;
}}

