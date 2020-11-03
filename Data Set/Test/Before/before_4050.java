class Dummy {
    @Override
    public void deleteSeasonById(String id) {
        String sql = "delete from nba.system where seasonid=" + id;
        Connection conn = DBUtil.open();
        try {
            Statement pstmt = conn.createStatement();
            pstmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }
    }
}
