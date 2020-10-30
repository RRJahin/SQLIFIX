public class Dummy{
public void Delete() throws Exception {
    if (_bIsDeleted)
        throw new Exception();
    Connection con = null;
    try {
        String st = "DELETE FROM marca WHERE Id = ?";
        con = Data.Connection();
        PreparedStatement ps = con.prepareStatement(st);
        ps.setObject(1,  _iId);
        ps.executeUpdate();
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

