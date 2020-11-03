public class Dummy{
@Override
public boolean create(ParcClient obj) {
    boolean result = false;
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String sql = "INSERT INTO ParcClient (codeTParc, codeCliPros, quantite, date, nom) VALUES ("+obj.getCodeTParc()+", "+obj.getCodeCliPros()+", "+Integer.toString(obj.getQuantite())+", "+(obj.getDate() == null) ? "" : formatter.format(obj.getDate())+", "+obj.getNom()+")";
    try {
        Statement insert = connect.createStatement();
        int rs = insert.executeUpdate(sql);
        result = (rs != 0);
    } catch (SQLException ex) {
        String message = "Erreur 100 090\nErreur Insert base de données\n" + ex.getClass().getName() + "\n" + ex.getMessage();
        MessageDialog.displayError(message);
        ex.printStackTrace();
        System.exit(0);
    }
    return result;
}}

