public class Dummy{
public int findNbByCategoryAndProspect(int codeParc) {
    int resultat = 0;
    String sql = "SELECT SUM(quantite) AS nb FROM ParcClient WHERE codeTParc = "+codeParc + " AND codeCliPros IN " + "  (SELECT codeProspect FROM Prospect WHERE cRep =  "+PanelStats.commercialStats.getCodeCommercial() + "  OR codeProspect IN" + "    (SELECT codeCliPros FROM Revoir WHERE codeUtilisateur = "+PanelStats.commercialStats.getId()+")  )";
    try {
        Statement select = this.connect.createStatement();
        ResultSet rs = select.executeQuery(sql);
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

