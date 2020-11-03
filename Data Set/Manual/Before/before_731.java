public class Dummy{
public void Delete() throws Exception {
    if (_bIsDeleted)
        throw new Exception();
    Connection con = null;
    try {
        con = Data.Connection();
        con.createStatement().executeUpdate("DELETE FROM marca WHERE Id = " + _iId);
        if (_iId_Imagen != -1)
            new Imagen(_iId_Imagen).Delete();
        _bIsDeleted = true;
    } catch (SQLException ee) {
        throw ee;
    } finally {
        if (con != null)
            con.close();
    }
}}

