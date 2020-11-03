public class Dummy{
@Override
public ParcClient find(int id) {
    ParcClient obj = new ParcClient();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String sql = "SELECT * FROM ParcClient WHERE id = ?";
    try {
        PreparedStatement select = this.connect.prepareStatement(sql);
        select.setObject(1, id);
        ResultSet rs = select.executeQuery();
        obj.setId(rs.getInt("id"));
        obj.setCodeTParc(rs.getString("codeTParc"));
        obj.setCodeCliPros(rs.getString("codeCliPros"));
        obj.setQuantite(rs.getInt("quantite"));
        obj.setObject((rs.getString("date").equals("")) ? null : formatter.parse(rs.getString("date")));
        obj.setNom(rs.getString("nom"));
        rs.close();
    } catch (SQLException ex) {
        String message = "Erreur 100 093\nErreur Recherche base de données\n" + ex.getClass().getName() + "\n" + ex.getMessage();
        MessageDialog.displayError(message);
        ex.printStackTrace();
        System.exit(0);
    } catch (ParseException ex) {
        String message = "Erreur 100 196\nErreur Format de Date\n" + ex.getClass().getName() + "\n" + ex.getMessage();
        MessageDialog.displayError(message);
        ex.printStackTrace();
        System.exit(0);
    }
    return obj;
}}

