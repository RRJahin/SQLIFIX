public class Dummy{
public boolean modifier(Variete variete) {
    Connection connexion = ConnexionBD.getConnexion();
    int aoc = 0;
    try {
        Statement requete = connexion.createStatement();
        if (variete.isAoc()) {
            aoc = 1;
        }
        int resultat = requete.executeUpdate("UPDATE VARIETE SET aoc = " + aoc + " where libelle = '" + variete.getLibelle() + "' ;");
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

