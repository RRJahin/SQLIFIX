class Dummy{
public void addRelation(String mot1, String nomRelation, String mot2) throws SQLException {
    String REQUETE = "INSERT INTO Relations(Mot1, NomRelation, Mot2) VALUES('" + mot1 + "','" + nomRelation + "','" + mot2 + "');";
    System.out.println(REQUETE);
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

