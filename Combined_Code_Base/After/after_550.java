import java.sql.PreparedStatement;

public class Dummy{
public boolean ajouter(Variete variete) {
    Connection connexion = ConnexionBD.getConnexion();
    int aoc = 0;
    try {
        PreparedStatement requete = connexion.prepareStatement("INSERT INTO VARIETE VALUES (?,?) ;");
        if (variete.isAoc()) {
            aoc = 1;
        }
        requete.setObject(1, variete.getLibelle());
        requete.setObject(2, aoc );
        int resultat = requete.executeUpdate();
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

