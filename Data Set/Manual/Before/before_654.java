class Dummy{
public boolean ajouter(Variete variete) {
    Connection connexion = ConnexionBD.getConnexion();
    int aoc = 0;
    try {
        Statement requete = connexion.createStatement();
        if (variete.isAoc()) {
            aoc = 1;
        }
        int resultat = requete.executeUpdate("INSERT INTO VARIETE VALUES ('" + variete.getLibelle() + "'," + aoc + ") ;");
        if (resultat == 1) {
            return true;
        } else {
            return false;
        }
    } catch (Exception e) {
        System.out.println("Erreur dans DaoVarietes::ajouter(variete)...");
        return false;
    }
}}

