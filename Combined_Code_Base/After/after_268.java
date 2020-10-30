public class Dummy{
@Override
public boolean create(ParcClient obj) {
    boolean result = false;
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String sql = "INSERT INTO ParcClient (codeTParc, codeCliPros, quantite, date, nom) VALUES (?, ?, ?, ?, ?)";
    try {
        PreparedStatement insert = connect.prepareStatement(sql);
        insert.setObject(1, obj.getCodeTParc());
        insert.setObject(2, obj.getCodeCliPros());
        insert.setObject(3, Integer.toString(obj.getQuantite()));
        insert.setObject(4, (obj.getDate() == null) ? "" : formatter.format(obj.getDate()));
        insert.setObject(5, obj.getNom());
        int rs = insert.executeUpdate();
        result = (rs != 0);
    } catch (SQLException ex) {
        String message = "Erreur 100 090\nErreur Insert base de données\n" + ex.getClass().getName() + "\n" + ex.getMessage();
        MessageDialog.displayError(message);
        ex.printStackTrace();
        System.exit(0);
    }
    return result;
}}

