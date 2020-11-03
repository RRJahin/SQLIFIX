class Dummy{
public void Delete() throws Exception {
    if (_bIsDeleted)
        throw new Exception();
    Connection con = null;
    try {
        con = Data.Connection();
        if (con.createStatement().executeQuery("SELECT * " + "FROM articulo_color " + "WHERE Id_Color = " + _iId).next())
            throw new Exception() {

                @Override
                public String toString() {
                    return "Este color está asociado a un artículo.";
                }
            };
        con.createStatement().executeUpdate("DELETE FROM articulo_color WHERE Id_Color = " + _iId);
        con.createStatement().executeUpdate("DELETE FROM articulo_color_imagen WHERE Id_Color = " + _iId);
        con.createStatement().executeUpdate("DELETE FROM stock WHERE Id_Color = " + _iId);
        con.createStatement().executeUpdate("DELETE FROM color WHERE Id = " + _iId);
        ResultSet rs = con.createStatement().executeQuery("SELECT Id_Imagen FROM Articulo_Color_Imagen " + "WHERE Id_Color = " + _iId);
        while (rs.next()) new Imagen(rs.getInt("Id_Imagen")).Delete();
        _bIsDeleted = true;
    } catch (SQLException ee) {
        throw ee;
    } finally {
        if (con != null)
            con.close();
    }
}}

