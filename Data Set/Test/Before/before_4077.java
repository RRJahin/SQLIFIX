class Dummy {
    public void modificarEsfuerzo(Tarea t) {
        String sql = "UPDATE tarea SET esfuerzo =  " + t.getEsfuerzo() + "WHERE id = " + t.getId();
        try {
            Statement pstmt = con.createStatement();
            pstmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new AgilException(e);
        }
    }
}
