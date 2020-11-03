public class Dummy{
@Override
public boolean update(ParcClient obj) {
    boolean result = false;
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String sql = "UPDATE ParcClient SET codeTParc = "+obj.getCodeTParc()+", codeCliPros = "+obj.getCodeCliPros()+", quantite = "+Integer.toString(obj.getQuantite())+", date = "+formatter.format(obj.getDate())+", nom = "+obj.getNom()+" WHERE id = "+obj.getId();
    try {
        Statement update = connect.createStatement();
        int rs = update.executeUpdate(sql);
        result = (rs != 0);
    } catch (SQLException ex) {
        String message = "Erreur 100 092\nErreur Update base de données\n" + ex.getClass().getName() + "\n" + ex.getMessage();
        MessageDialog.displayError(message);
        ex.printStackTrace();
        System.exit(0);
    }
    return result;
}}

