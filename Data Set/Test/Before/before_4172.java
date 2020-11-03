class Dummy{
public static Color Create(String sNombre) throws SQLException {
    Connection con = null;
    try {
        con = Data.Connection();
        con.createStatement().executeUpdate("INSERT INTO color (Nombre)" + " VALUES (" + Data.String2Sql(sNombre, true, false) + ");");
        return new Color(Data.LastId(con));
    } catch (SQLException e) {
        throw e;
    } finally {
        if (con != null)
            con.close();
    }
}}

