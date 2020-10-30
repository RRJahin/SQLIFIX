public class Dummy{
public static ArrayList<Pedido> Select(Date Fecha, Integer iNumArticulos, Double dTotal, Integer iCodPostal, String sDirEnvio) throws SQLException {
    ArrayList<Pedido> aPedidos = new ArrayList<>();
    Connection con = null;
    ResultSet rs = null;
    try {
        con = Data.Connection();
        rs = con.prepareStatement().executeQuery("SELECT Id FROM pedido" + Where(Fecha, iNumArticulos, dTotal, iCodPostal, sDirEnvio));
        while (rs.next()) aPedidos.add(new Pedido(rs.getInt("Id")));
        return aPedidos;
    } catch (SQLException ee) {
        throw ee;
    } finally {
        if (rs != null)
            rs.close();
        if (con != null)
            con.close();
    }
}}

