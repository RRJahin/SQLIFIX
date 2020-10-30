public class Dummy{
public ParcClient findByCode(String codeClient, int idType) {
    ParcClient obj = null;
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String sql = "SELECT * FROM ParcClient WHERE codeTParc = "+idType+" AND codeCliPros = "+codeClient;
    try {
        Statement select = this.connect.createStatement();
        ResultSet rs = select.executeQuery(sql);
        if (rs.isBeforeFirst()) {
            obj = new ParcClient();
            obj.setId(rs.getInt("id"));
            obj.setCodeTParc(rs.getString("codeTParc"));
            obj.setCodeCliPros(rs.getString("codeCliPros"));
            obj.setQuantite(rs.getInt("quantite"));
            obj.setDate((rs.getString("date").equals("")) ? null : formatter.parse(rs.getString("date")));
            obj.setNom(rs.getString("nom"));
        }
        rs.close();
    } catch (SQLException ex) {
        String message = "Erreur 100 095\nErreur Recherche base de données\n" + ex.getClass().getName() + "\n" + ex.getMessage();
        MessageDialog.displayError(message);
        ex.printStackTrace();
        System.exit(0);
    } catch (ParseException ex) {
        String message = "Erreur 100 198\nErreur Format de Date\n" + ex.getClass().getName() + "\n" + ex.getMessage();
        MessageDialog.displayError(message);
        ex.printStackTrace();
        System.exit(0);
    }
    return obj;
}}

