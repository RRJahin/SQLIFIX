public class Dummy{
public void Update() throws Exception {
    if (_bIsDeleted)
        throw new Exception();
    Connection con = null;
    try {
        con = Data.Connection();
        con.createStatement().executeUpdate("UPDATE pedido " + "SET Fecha = " + Data.String2Sql(_Fecha.toString(), true, false) + ", CodPostal = " + _iCodPostal + ", DirEnvio = " + Data.String2Sql(_sDirEnvio, true, false) + " WHERE Id = " + _iId);
        if (_aiArticulosStock != null) {
            con.createStatement().executeUpdate("DELETE FROM pedido_stock WHERE Id_Pedido = " + _iId);
            for (Integer iId_Stock : _aiArticulosStock) con.createStatement().executeUpdate("INSERT INTO pedido_stock " + "(Id_Pedido, Id_Stock)" + " VALUES (" + _iId + ", " + iId_Stock + ");");
        }
    } catch (SQLException ee) {
        throw ee;
    } finally {
        if (con != null)
            con.close();
    }
}}

