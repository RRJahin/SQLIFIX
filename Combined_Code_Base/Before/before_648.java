class Dummy{
@Override
public boolean create(FamClient obj) {
    boolean result = false;
    String sql = "INSERT INTO FamClient (codeFamClient, nomFamClient) VALUES ("+obj.getCodeFamClient()+", "+obj.getNomFamClient()+")";
    try {
        Statement insert = connect.createStatement();
        int rs = insert.executeUpdate(sql);
        result = (rs != 0);
    } catch (SQLException ex) {
        String message = "Erreur 100 060\nErreur Insert base de données\n" + ex.getClass().getName() + "\n" + ex.getMessage();
        MessageDialog.displayError(message);
        ex.printStackTrace();
        System.exit(0);
    }
    return result;
}}

