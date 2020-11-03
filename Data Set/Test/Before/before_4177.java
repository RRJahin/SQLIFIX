class Dummy{
public void Update() throws SQLException {
    Connection con = null;
    try {
        con = Data.Connection();
        con.createStatement().executeUpdate("UPDATE configuracion " + "SET Campo = " + Data.String2Sql(_sCampo, true, false) + ", Valor = " + Data.String2Sql(_sValor, true, false) + " WHERE Id = " + _iId);
    } catch (SQLException e) {
        throw e;
    } finally {
        if (con != null)
            con.close();
    }
}}

