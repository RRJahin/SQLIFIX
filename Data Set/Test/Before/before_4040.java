class Dummy {
    public void modificar(Tarea t) {
        String sql = "UPDATE tarea SET nombre = " + t.getNombre() + ", descripcion = " + t.getDescripcion() + ", "
                + "fecha = " + new java.sql.Date(t.getFecha().getTime()) + ", valor = " + t.getValor() + ", estado = "
                + t.getEstado().name() + ", iteracion_id = " + t.getIteracion().getId() + " " + "WHERE id = "
                + t.getId();
        try {
            Statement pstmt = con.createStatement();
            pstmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new AgilException(e);
        }
    }
}
