class Dummy {
    @Override
    public SeasonTracker getStById(String id) {
        SeasonTracker st = new SeasonTracker();
        String sql = "select currentdate,seasonid from nba.system where seasonid=" + id;
        Connection conn = DBUtil.open();
        try {
            Statement pstmt = conn.createStatement();
            ResultSet rs = pstmt.executeQuery(sql);
            while (rs.next()) {
                st.setCurrentDate(new GameDate(rs.getString("currentdate")));
                st.setSeasonId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }
        return st;
    }
}
