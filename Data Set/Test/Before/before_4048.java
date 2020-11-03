class Dummy {
    @Override
    public void add(SeasonTracker st) {
        String sql = "insert into nba.system(currentdate,seasonid)values(" + st.getCurrentDate().toString() + ","
                + st.getSeasonId() + ")";
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
