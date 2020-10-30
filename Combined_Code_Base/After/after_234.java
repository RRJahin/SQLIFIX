public class Dummy{
@Override
public OptionVisite find(int id) {
    OptionVisite obj = new OptionVisite();
    String sql = "SELECT * FROM OptionVisite WHERE id = ?";
    try {
        PreparedStatement select = this.connect.prepareStatement(sql);
        select.setObject(1, id);
        ResultSet rs = select.executeQuery();
        obj.setId(rs.getInt("id"));
        obj.setLabel(rs.getString("label"));
        obj.setNiveau(rs.getInt("niveau"));
        obj.setParent(rs.getInt("parent"));
        obj.setType(rs.getString("type"));
        obj.setTypeB(rs.getString("typeB"));
        rs.close();
    } catch (SQLException ex) {
        String message = "Erreur 100 083\nErreur Recherche base de données\n" + ex.getClass().getName() + "\n" + ex.getMessage();
        MessageDialog.displayError(message);
        ex.printStackTrace();
        System.exit(0);
    }
    return obj;
}}

