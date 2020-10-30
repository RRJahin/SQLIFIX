public class Dummy{
public static Pedido Create(Date Fecha, Integer iCodPostal, String sDirEnvio, ArrayList<Integer> aiArticulosStock) throws SQLException {
    Connection con = null;
    try {
        con = Data.Connection();
        con.createStatement().executeUpdate("INSERT INTO pedido " + "(Fecha, CodPostal, DirEnvio)" + " VALUES (" + Data.String2Sql(Fecha.toString(), true, false) + ", " + iCodPostal + ", " + Data.String2Sql(sDirEnvio, true, false) + ");");
        int iId = Data.LastId(con);
        if (aiArticulosStock != null)
            for (Integer iId_Stock : aiArticulosStock) con.createStatement().executeUpdate("INSERT INTO pedido_stock " + "(Id_Pedido, Id_Stock)" + " VALUES (" + iId + ", " + iId_Stock + ");");
        return new Pedido(iId);
    } catch (SQLException ee) {
        throw ee;
    } finally {
        if (con != null)
            con.close();
    }
}}

