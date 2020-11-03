class Dummy {
    public void deleteStud(long id) {
        String sql = "DELETE FROM STUDENTS WHERE ID = " + id;
        Connection con = ConnectionSingleton.getInstance();
        try {
            Statement ps = con.createStatement();
            ps.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
