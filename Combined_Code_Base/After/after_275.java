public class Dummy{
public int findNbByCategoryAndProspect(int codeParc) {
    int resultat = 0;
    String sql = "SELECT SUM(quantite) AS nb FROM ParcClient WHERE codeTParc = ?" + " AND codeCliPros IN " + "  (SELECT codeProspect FROM Prospect WHERE cRep = ? " + "  OR codeProspect IN" + "    (SELECT codeCliPros FROM Revoir WHERE codeUtilisateur = ?)" + "  )";
    try {
        PreparedStatement select = this.connect.prepareStatement(sql);
        select.setObject(1, codeParc);
        select.setObject(2, PanelStats.commercialStats.getCodeCommercial());
        select.setObject(3, PanelStats.commercialStats.getId());
        ResultSet rs = select.executeQuery();
        while (rs.next()) {
            resultat = rs.getInt("nb");
        }
        rs.close();
    } catch (SQLException ex) {
        String message = "Erreur 100 023\nErreur Recherche base de données\n" + ex.getClass().getName() + "\n" + ex.getMessage();
        MessageDialog.displayError(message);
        ex.printStackTrace();
        System.exit(0);
    }
    return resultat;
}}

