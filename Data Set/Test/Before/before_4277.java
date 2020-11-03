class Dummy{
public Iteracion agregar(Iteracion i) {
    String sql = "INSERT INTO iteracion(nombre, descripcion) VALUES("+i.getNombre()+", "+i.getDescripcion()+")";
    try {
        Statement pstmt = con.createStatement();
        pstmt.executeUpdate(sql);
        ResultSet rs = pstmt.getGeneratedKeys();
        if (rs.next())
            i.setId(rs.getInt(1));
    } catch (SQLException e) {
        throw new AgilException(e);
    }
    return i;
}}

