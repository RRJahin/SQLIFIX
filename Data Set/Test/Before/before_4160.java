class Dummy{
public static ArrayList<Categoria> Select(String sNombre, Integer iId_Imagen, Integer iId_Marca) throws SQLException {
    ArrayList<Categoria> aCategorias = new ArrayList<>();
    Connection con = null;
    ResultSet rs = null;
    try {
        con = Data.Connection();
        rs = con.createStatement().executeQuery("SELECT Id FROM categoria" + Where(sNombre, iId_Imagen, iId_Marca));
        while (rs.next()) aCategorias.add(new Categoria(rs.getInt("Id")));
        return aCategorias;
    } catch (SQLException e) {
        throw e;
    } finally {
        if (rs != null)
            rs.close();
        if (con != null)
            con.close();
    }
}}

