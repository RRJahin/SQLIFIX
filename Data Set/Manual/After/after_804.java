public class Dummy{
@Override
public ModRgl find(int id) {
    ModRgl obj = new ModRgl();
    String sql = "SELECT * FROM ModRgl WHERE id = ?";
    try {
        PreparedStatement select = this.connect.prepareStatement(sql);
        select.setObject(1, id);
        ResultSet rs = select.executeQuery();
        if (rs.isBeforeFirst()) {
            obj.setId(rs.getInt("id"));
            obj.setCodeModRgl(rs.getString("codeModRgl"));
            obj.setNomModRgl(rs.getString("nomModRgl"));
        } else {
            obj.setId(0);
            obj.setCodeModRgl("NM");
            obj.setNomModRgl("Non modifiable");
        }
        rs.close();
    } catch (SQLException ex) {
        String message = "Erreur 100 073\nErreur Recherche base de données\n" + ex.getClass().getName() + "\n" + ex.getMessage();
        MessageDialog.displayError(message);
        ex.printStackTrace();
        System.exit(0);
    }
    return obj;
}}

