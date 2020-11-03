public class Dummy{
public Pays findByCode(String code) {
    Pays pays = new Pays();
    String sql = "SELECT * FROM Pays WHERE codePays = "+code;
    try {
        Statement select = this.connect.createStatement();
        ResultSet rs = select.executeQuery(sql);
        if (rs.isBeforeFirst()) {
            pays.setId(rs.getInt("id"));
            pays.setCodePays(rs.getString("codePays"));
            pays.setNomPays(rs.getString("nomPays"));
        }
        rs.close();
    } catch (SQLException ex) {
        String message = "Erreur 100 105\nErreur Recherche base de données\n" + ex.getClass().getName() + "\n" + ex.getMessage();
        MessageDialog.displayError(message);
        ex.printStackTrace();
        System.exit(0);
    }
    return pays;
}}

