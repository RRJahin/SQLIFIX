public class Dummy{
@Override
public Agence find(int id) {
    Agence obj = new Agence();
    String sql = "SELECT * FROM Agence WHERE id = ?";
    try {
        PreparedStatement select = this.connect.prepareStatement(sql);
        select.setObject(1, id);
        ResultSet rs = select.executeQuery();
        obj.setId(rs.getInt("id"));
        obj.setCodeAgence(rs.getString("codeAgence"));
        obj.setNomAgence(rs.getString("nomAgence"));
        rs.close();
    } catch (SQLException ex) {
        String message = "Erreur 100 003\nErreur Recherche base de données\n" + ex.getClass().getName() + "\n" + ex.getMessage();
        MessageDialog.displayError(message);
        ex.printStackTrace();
        System.exit(0);
    }
    return obj;
}
}

