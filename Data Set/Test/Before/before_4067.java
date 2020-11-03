class Dummy{
public static ArrayList<Talla> Select(String sNombre, Boolean Es_Numero) throws SQLException {
    ArrayList<Talla> aTallas = new ArrayList<>();
    Connection con = null;
    ResultSet rs = null;
    try {
        String sQuery = "SELECT Id FROM talla" + Where(sNombre, Es_Numero);
        if (Es_Numero != null && Es_Numero)
            sQuery += " ORDER BY Nombre";
        con = Data.Connection();
        rs = con.createStatement().executeQuery(sQuery);
        while (rs.next()) aTallas.add(new Talla(rs.getInt("Id")));
        return aTallas;
    } catch (SQLException ee) {
        throw ee;
    } finally {
        if (rs != null)
            rs.close();
        if (con != null)
            con.close();
    }
}}

