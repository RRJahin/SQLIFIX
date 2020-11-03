class Dummy{
public Iteracion agregar(Iteracion i) {
    String sql = "INSERT INTO iteracion(nombre, descripcion, " + "fecha_inicio, fecha_fin) VALUES("+i.getNombre()+", "+i.getDescripcion()+", "+new java.sql.Date(i.getFechaInicio().getTime())+", "+new java.sql.Date(i.getFechaFin().getTime())+")";
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

