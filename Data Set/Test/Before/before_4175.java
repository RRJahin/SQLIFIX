class Dummy{
public static ArrayList<Color> Select(String sNombre) throws SQLException {
    ArrayList<Color> aColores = new ArrayList<>();
    Connection con = null;
    ResultSet rs = null;
    try {
        con = Data.Connection();
        rs = con.createStatement().executeQuery("SELECT Id FROM color" + Where(sNombre) + " ORDER BY Nombre");
        while (rs.next()) aColores.add(new Color(rs.getInt("Id")));
        return aColores;
    } catch (SQLException e) {
        throw e;
    } finally {
        if (rs != null)
            rs.close();
        if (con != null)
            con.close();
    }
}}

