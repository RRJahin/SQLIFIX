public class Dummy{
public static ArrayList<Marca> Select(String sNombre, Integer iId_Imagen) throws SQLException {
    ArrayList<Marca> aMarcas = new ArrayList<>();
    Connection con = null;
    ResultSet rs = null;
    try {
        String st = "SELECT Id FROM marca ?";
        con = Data.Connection();
        PreparedStatement ps = con.prepareStatement(st);
        ps.setObject(1, Where(sNombre, iId_Imagen));
        rs = ps.executeQuery();
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

