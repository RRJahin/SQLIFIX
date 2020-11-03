public class Dummy{
public ModRgl findByCode(String code) {
    ModRgl obj = new ModRgl();
    String sql = "SELECT * FROM ModRgl WHERE codeModRgl = "+code;
    try {
        Statement select = this.connect.createStatement();
        ResultSet rs = select.executeQuery(sql);
        if (rs.isBeforeFirst()) {
            obj.setId(rs.getInt("id"));
            obj.setCodeModRgl(rs.getString("codeModRgl"));
            obj.setNomModRgl(rs.getString("nomModRgl"));
        } else {
            obj.setId(0);
            obj.setCodeModRgl("XX");
            obj.setNomModRgl("Non modifiable");
        }
        rs.close();
    } catch (SQLException ex) {
        String message = "Erreur 100 075\nErreur Recherche base de données\n" + ex.getClass().getName() + "\n" + ex.getMessage();
        MessageDialog.displayError(message);
        ex.printStackTrace();
        System.exit(0);
    }
    return obj;
}}

