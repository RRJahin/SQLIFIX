class Dummy{
public void Delete() throws Exception {
    if (_bIsDeleted)
        throw new Exception();
    Connection con = null;
    try {
        con = Data.Connection();
        con.createStatement().executeUpdate("DELETE FROM talla WHERE Id = " + _iId);
        _bIsDeleted = true;
    } catch (SQLException ee) {
        throw ee;
    } finally {
        if (con != null)
            con.close();
    }
}}

