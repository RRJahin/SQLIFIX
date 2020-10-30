class Dummy{
public Variete consulter(String libelle) {
    Variete variete = null;
    Connection connexion = ConnexionBD.getConnexion();
    try {
        String sql="select aoc from VARIETE where libelle=?;";
        PreparedStatement requete = connexion.prepareStatement(sql);
        requete.setObject(1, libelle);
        ResultSet resultat = requete.executeQuery();
        if (resultat.next()) {
            boolean aoc = false;
            if (resultat.getInt("aoc") == 1) {
                aoc = true;
            }
            variete = new Variete(libelle, aoc);
        }
        resultat.close();
        requete.close();
    } catch (Exception e) {
        System.out.println("Erreur dans DaoVarietes::consulter(String)...");
    }
    return variete;
}}

