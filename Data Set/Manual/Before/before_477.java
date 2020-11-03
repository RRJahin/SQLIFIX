public class Dummy{
public Agence findByCode(String code) {
    Agence obj = new Agence();
    String sql = "SELECT * FROM Agence WHERE codeAgence = "+code;
    try {
        Statement select = this.connect.createStatement();
        ResultSet rs = select.executeQuery(sql);
        obj.setId(rs.getInt("id"));
        obj.setCodeAgence(rs.getString("codeAgence"));
        obj.setNomAgence(rs.getString("nomAgence"));
        rs.close();
    } catch (SQLException ex) {
        String message = "Erreur 100 005\nErreur Recherche base de données\n" + ex.getClass().getName() + "\n" + ex.getMessage();
        MessageDialog.displayError(message);
        ex.printStackTrace();
        System.exit(0);
    }
    return obj;
}}

