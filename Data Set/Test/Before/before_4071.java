class Dummy {
    public void eliminar(Integer id) {
        String sql = "DELETE FROM tarea WHERE id = " + id;
        try {
            Statement pstmt = con.createStatement();
            pstmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new AgilException(e);
        }
    }
}
