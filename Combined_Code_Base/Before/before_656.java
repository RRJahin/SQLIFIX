class Dummy{
public boolean supprimer(String libelle) {
    Connection connexion = ConnexionBD.getConnexion();
    try {
        Statement requete = connexion.createStatement();
        int resultat = requete.executeUpdate("DELETE FROM VARIETE where libelle ='" + libelle + "';");
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

