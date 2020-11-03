class Dummy{
public boolean supprimer(String libelle) {
    Connection connexion = ConnexionBD.getConnexion();
    try {
        String sql="DELETE FROM VARIETE where libelle=?;";
        PreparedStatement requete = connexion.prepareStatement(sql);
        requete.setObject(1, libelle);
        int resultat = requete.executeUpdate();
        if (resultat == 1) {
            return true;
        } else {
            return false;
        }
    } catch (Exception e) {
        System.out.println("Erreur dans DaoVarietes::supprimer(String)...");
        return false;
    }
}}

