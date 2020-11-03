class Dummy{
public void Update() throws Exception {
    if (_bIsDeleted)
        throw new Exception();
    Connection con = null;
    try {
        con = Data.Connection();
        con.createStatement().executeUpdate("UPDATE color " + "SET Nombre = " + Data.String2Sql(_sNombre, true, false) + " WHERE Id = " + _iId);
    } catch (SQLException e) {
        throw e;
    } finally {
        if (con != null)
            con.close();
    }
}}

