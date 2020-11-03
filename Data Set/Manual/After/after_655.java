class Dummy{
public boolean modifier(Variete variete) {
    Connection connexion = ConnexionBD.getConnexion();
    int aoc = 0;
    try {
        PreparedStatement requete = connexion.prepareStatement("UPDATE VARIETE SET aoc = ?  where libelle = ?;");
        if (variete.isAoc()) {
            aoc = 1;
        }
        requete.setObject(1, aoc );
        requete.setObject(2, variete.getLibelle());
        
        int resultat = requete.executeUpdate();
        if (resultat == 1) {
            return true;
        } else {
            return false;
        }
    } catch (Exception e) {
        System.out.println("Erreur dans DaoVarietes::modifier(variete)...");
        return false;
    }
}}

