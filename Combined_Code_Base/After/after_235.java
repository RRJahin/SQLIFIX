public class Dummy{
public List<OptionVisite> findAllByType(String valeur) {
    List<OptionVisite> resultat = new ArrayList<>();
    String sql = "SELECT * FROM OptionVisite WHERE type = ? and niveau = 0";
    try {
        PreparedStatement select = this.connect.prepareStatement(sql);
        select.setObject(1, valeur);
        ResultSet rs = select.executeQuery();
        while (rs.next()) {
            OptionVisite obj = new OptionVisite();
            obj.setId(rs.getInt("id"));
            obj.setLabel(rs.getString("label"));
            obj.setNiveau(rs.getInt("niveau"));
            obj.setParent(rs.getInt("parent"));
            obj.setType(rs.getString("type"));
            obj.setTypeB(rs.getString("typeB"));
            resultat.add(obj);
        }
        rs.close();
    } catch (SQLException ex) {
        String message = "Erreur 100 085\nErreur Recherche base de données\n" + ex.getClass().getName() + "\n" + ex.getMessage();
        MessageDialog.displayError(message);
        ex.printStackTrace();
        System.exit(0);
    }
    return resultat;
}}

