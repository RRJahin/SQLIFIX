public class Dummy{
@Override
public boolean update(ParcClient obj) {
    boolean result = false;
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String sql = "UPDATE ParcClient SET codeTParc = ?, codeCliPros = ?, quantite = ?, date = ?, nom = ? WHERE id = ?";
    try {
        PreparedStatement update = connect.prepareStatement(sql);
        update.setObject(1, obj.getCodeTParc());
        update.setObject(2, obj.getCodeCliPros());
        update.setObject(3, Integer.toString(obj.getQuantite()));
        update.setObject(4, formatter.format(obj.getDate()));
        update.setObject(5, obj.getNom());
        update.setObject(6, obj.getId());
        int rs = update.executeUpdate();
        result = (rs != 0);
    } catch (SQLException ex) {
        String message = "Erreur 100 092\nErreur Update base de données\n" + ex.getClass().getName() + "\n" + ex.getMessage();
        MessageDialog.displayError(message);
        ex.printStackTrace();
        System.exit(0);
    }
    return result;
}}

