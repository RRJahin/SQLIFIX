class Dummy {
    @Override
    public ArrayList<String> getUpdateGameList(String seasonID) {
        String sql = "select updategamelist from nba.system where seasonid=" + seasonID;
        Connection conn = DBUtil.open();
        String got = new String();
        try {
            Statement pstmt = conn.createStatement();
            ResultSet rs = pstmt.executeQuery(sql);
            while (rs.next()) {
                got = rs.getString("updategamelist");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }
        String[] array = got.split(";");
        ArrayList<String> result = new ArrayList<String>();
        for (String single : array) {
            result.add(single);
        }
        return result;
    }
}
