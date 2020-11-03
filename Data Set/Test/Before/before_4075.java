class Dummy {
    public Tarea agregar(Tarea t) {
        String sql = "INSERT INTO tarea(nombre, descripcion, " + "prioridad, esfuerzo, release, "
                + "fecha, valor, estado, iteracion_id) " + "VALUES(" + t.getNombre() + ", " + t.getDescripcion() + ", "
                + t.getPrioridad() + ", " + t.getEsfuerzo() + ", " + t.getRelease() + ", "
                + new java.sql.Date(t.getFecha().getTime()) + ", " + t.getValor() + ", " + t.getEstado().name() + ", "
                + t.getIteracion().getId() + ")";
        try {
            Statement pstmt = con.createStatement();
            pstmt.executeUpdate(sql);
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next())
                t.setId(rs.getInt(1));
        } catch (SQLException e) {
            throw new AgilException(e);
        }
        return t;
    }
}
