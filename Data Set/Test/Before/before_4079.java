class Dummy {
    public Tarea obtener(Integer id) {
        String sql = "SELECT * FROM tarea WHERE id = " + id;
        Tarea t = null;
        try {
            Statement pstmt = con.createStatement();
            ResultSet rs = pstmt.executeQuery(sql);
            if (rs.next()) {
                t = new Tarea();
                t.setId(rs.getInt("id"));
                t.setNombre(rs.getString("nombre"));
                t.setDescripcion(rs.getString("descripcion"));
                t.setPrioridad(rs.getInt("prioridad"));
                t.setEsfuerzo(rs.getInt("esfuerzo"));
                t.setRelease(rs.getString("release"));
                t.setValor(rs.getInt("valor"));
                t.setEstado(Tarea.Estado.valueOf(rs.getString("estado")));
                t.setFecha(rs.getDate("fecha"));
                Iteracion i = new Iteracion();
                i.setId(rs.getInt("iteracion_id"));
                t.setIteracion(i);
            }
        } catch (SQLException e) {
            throw new AgilException(e);
        }
        return t;
    }
}
