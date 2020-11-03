class Dummy{
public void Update() throws Exception {
    if (_bIsDeleted)
        throw new Exception();
    Connection con = null;
    try {
        con = Data.Connection();
        con.createStatement().executeUpdate("UPDATE talla " + "SET Nombre = " + Data.String2Sql(_sNombre, true, false) + ", Es_Numero = " + Data.Boolean2Sql(_bEs_Numero) + " WHERE Id = " + _iId);
    } catch (SQLException ee) {
        throw ee;
    } finally {
        if (con != null)
            con.close();
    }
}}

