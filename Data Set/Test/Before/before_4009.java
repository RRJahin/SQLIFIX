class Dummy{
public static Stock Create(int iId_Articulo, int iId_Color, int iId_Talla) throws SQLException {
    Connection con = null;
    try {
        con = Data.Connection();
        con.createStatement().executeUpdate("INSERT INTO stock " + "(Id_Articulo, Id_Color, Id_Talla, Existencias)" + " VALUES (" + iId_Articulo + ", " + iId_Color + ", " + iId_Talla + ",0);");
        return new Stock(Data.LastId(con));
    } catch (SQLException ee) {
        throw ee;
    } finally {
        if (con != null)
            con.close();
    }
}}

