public class Dummy{
public int hasChild(int id) {
    int nbChilds = 0;
    String sql = "SELECT COUNT(*) AS nb FROM OptionVisite WHERE parent = ?";
    try {
        PreparedStatement select = this.connect.prepareStatement(sql);
        select.setObject(1, id);
        ResultSet rs = select.executeQuery();
        nbChilds = rs.getInt("nb");
        rs.close();
    } catch (SQLException ex) {
        String message = "Erreur 100 086\nErreur Recherche base de données\n" + ex.getClass().getName() + "\n" + ex.getMessage();
        MessageDialog.displayError(message);
        ex.printStackTrace();
        System.exit(0);
    }
    return nbChilds;
}}

