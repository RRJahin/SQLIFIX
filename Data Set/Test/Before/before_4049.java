class Dummy {
    @Override
    public void update(SeasonTracker st) {
        String sql = "update nba.system set currentdate=" + st.getCurrentDate().toString() + " where seasonid="
                + st.getSeasonId();
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
