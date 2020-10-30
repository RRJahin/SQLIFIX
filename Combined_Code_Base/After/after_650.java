class Dummy{
@Override
public boolean update(FamClient obj) {
    boolean result = false;
    String sql = "UPDATE FamClient SET codeFamClient = ?, nomFamClient = ? WHERE id = ?";
    try {
        PreparedStatement update = connect.prepareStatement(sql);
        update.setObject(1, obj.getCodeFamClient());
        update.setObject(2, obj.getNomFamClient());
        update.setObject(3, obj.getId());
        int rs = update.executeUpdate();
        result = (rs != 0);
    } catch (SQLException ex) {
        String message = "Erreur 100 062\nErreur Update base de données\n" + ex.getClass().getName() + "\n" + ex.getMessage();
        MessageDialog.displayError(message);
        ex.printStackTrace();
        System.exit(0);
    }
    return result;
}}

