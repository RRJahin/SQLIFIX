class Dummy{
@Override
public boolean update(FamClient obj) {
    boolean result = false;
    String sql = "UPDATE FamClient SET codeFamClient = "+obj.getCodeFamClient()+", nomFamClient = "+obj.getNomFamClient()+" WHERE id = "+obj.getId();
    try {
        Statement update = connect.createStatement(sql);
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

