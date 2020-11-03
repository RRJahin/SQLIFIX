public class Dummy{
public void Update() throws Exception {
    if (_bIsDeleted)
        throw new Exception();
    Connection con = null;
    try {
        String st = "UPDATE marca " + "SET Nombre = ?, Id_Imagen = ? WHERE Id = ?";
        con = Data.Connection();
        PreparedStatement ps = con.prepareStatement(st);
        ps.setObject(1, Data.String2Sql(_sNombre, true, false));
        ps.setObject(2, _iId_Imagen);
        ps.setObject(3, _iId);
        ps.executeUpdate();
    } catch (SQLException ee) {
        throw ee;
    } finally {
        if (con != null)
            con.close();
    }
}}

