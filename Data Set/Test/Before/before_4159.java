class Dummy{
public void Update() throws Exception {
    if (_bIsDeleted)
        throw new Exception();
    Connection con = null;
    try {
        con = Data.Connection();
        con.createStatement().executeUpdate("UPDATE categoria " + "SET Nombre = " + Data.String2Sql(_sNombre, true, false) + ", Id_Imagen = " + _iId_Imagen + ", Id_Marca = " + _iId_Marca + " WHERE Id = " + _iId);
    } catch (SQLException ee) {
        throw ee;
    } finally {
        if (con != null)
            con.close();
    }
}}

