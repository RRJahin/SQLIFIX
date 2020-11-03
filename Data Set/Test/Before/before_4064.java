class Dummy{
public static Talla Create(String sNombre, boolean bEs_Numero) throws SQLException {
    Connection con = null;
    try {
        con = Data.Connection();
        con.createStatement().executeUpdate("INSERT INTO talla (Nombre, Es_Numero)" + " VALUES (" + Data.String2Sql(sNombre, true, false) + ", " + Data.Boolean2Sql(bEs_Numero) + ");");
        return new Talla(Data.LastId(con));
    } catch (SQLException ee) {
        throw ee;
    } finally {
        if (con != null)
            con.close();
    }
}}

