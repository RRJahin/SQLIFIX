class Dummy{
public void supprimerRelation(String mot1, String nomRelation, String mot2) throws SQLException {
    final String REQUETE = "DELETE FROM Relations WHERE Mot1 ='" + mot1 + "' AND nomRelation = '" + nomRelation + "'";
    Connection connexion = null;
    try {
        connexion = newConnection();
        Statement st = connexion.createStatement();
        st.executeUpdate(REQUETE);
    } finally {
        if (connexion != null)
            connexion.close();
    }
}}

