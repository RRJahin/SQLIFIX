public class Dummy{
public void Delete() throws Exception {
    if (_bIsDeleted)
        throw new Exception();
    Connection con = null;
    try {
        con = Data.Connection();
        con.prepareStatement().executeUpdate("DELETE FROM pedido_stock WHERE Id_Pedido = " + _iId);
        con.prepareStatement().executeUpdate("DELETE FROM pedido WHERE Id = " + _iId);
        _bIsDeleted = true;
    } catch (SQLException ee) {
        throw ee;
    } finally {
        if (con != null)
            con.close();
    }
}}

