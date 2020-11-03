class Dummy{
public static ArrayList<Configuracion> Select(String sCampo, String sValor) throws SQLException {
    ArrayList<Configuracion> aConfiguracion = new ArrayList<>();
    Connection con = null;
    ResultSet rs = null;
    try {
        con = Data.Connection();
        rs = con.createStatement().executeQuery("SELECT Id FROM configuracion" + Where(sCampo, sValor));
        while (rs.next()) aConfiguracion.add(new Configuracion(rs.getInt("Id")));
        return aConfiguracion;
    } catch (SQLException ee) {
        throw ee;
    } finally {
        if (rs != null)
            rs.close();
        if (con != null)
            con.close();
    }
}}

