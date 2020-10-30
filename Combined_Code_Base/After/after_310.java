public class Dummy{
@Override
public Pays find(int id) {
    Pays pays = new Pays();
    String sql = "SELECT * FROM Pays WHERE id = ?";
    try {
        PreparedStatement select = this.connect.prepareStatement(sql);
        select.setObject(1, id);
        ResultSet rs = select.executeQuery();
        pays.setId(rs.getInt("id"));
        pays.setCodePays(rs.getString("codePays"));
        pays.setNomPays(rs.getString("nomPays"));
        rs.close();
    } catch (SQLException ex) {
        String message = "Erreur 100 103\nErreur Recherche base de données\n" + ex.getClass().getName() + "\n" + ex.getMessage();
        MessageDialog.displayError(message);
        ex.printStackTrace();
        System.exit(0);
    }
    return pays;
}}

