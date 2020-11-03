class Dummy{
public FamClient findByCode(String code) {
    FamClient obj = new FamClient();
    String sql = "SELECT * FROM FamClient WHERE codeFamClient = ?";
    try {
        PreparedStatement select = this.connect.prepareStatement(sql);
        select.setObject(1, code);
        ResultSet rs = select.executeQuery();
        obj.setId(rs.getInt("id"));
        obj.setCodeFamClient(rs.getString("codeFamClient"));
        obj.setNomFamClient(rs.getString("nomFamClient"));
        rs.close();
    } catch (SQLException ex) {
        String message = "Erreur 100 065\nErreur Recherche base de données\n" + ex.getClass().getName() + "\n" + ex.getMessage();
        MessageDialog.displayError(message);
        ex.printStackTrace();
        System.exit(0);
    }
    return obj;
}}

