class Dummy{
public static Categoria Create(String sNombre, int iId_Imagen, int iId_Marca) throws SQLException {
    Connection con = null;
    try {
        con = Data.Connection();
        con.createStatement().executeUpdate("INSERT INTO categoria (Nombre, Id_Imagen, Id_Marca)" + " VALUES (" + Data.String2Sql(sNombre, true, false) + ", " + iId_Imagen + ", " + iId_Marca + ");");
        return new Categoria(Data.LastId(con));
    } catch (SQLException ee) {
        throw ee;
    } finally {
        if (con != null)
            con.close();
    }
}}

