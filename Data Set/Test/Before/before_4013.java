class Dummy{
public void Update() throws Exception {
    if (_bIsDeleted)
        throw new Exception();
    Connection con = null;
    try {
        con = Data.Connection();
        con.createStatement().executeUpdate("UPDATE stock " + "SET Existencias = " + _iExistencias + " WHERE " + "Id = " + _iId + ";");
    } catch (SQLException ee) {
        throw ee;
    } finally {
        if (con != null)
            con.close();
    }
}}

