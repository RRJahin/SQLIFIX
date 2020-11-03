public class Dummy{
public static ArrayList<Marca> Select(String sNombre, Integer iId_Imagen) throws SQLException {
    ArrayList<Marca> aMarcas = new ArrayList<>();
    Connection con = null;
    ResultSet rs = null;
    try {
        con = Data.Connection();
        rs = con.createStatement().executeQuery("SELECT Id FROM marca" + Where(sNombre, iId_Imagen));
        while (rs.next()) aMarcas.add(new Marca(rs.getInt("Id")));
        return aMarcas;
    } catch (SQLException ee) {
        throw ee;
    } finally {
        if (rs != null)
            rs.close();
        if (con != null)
            con.close();
    }
}}

