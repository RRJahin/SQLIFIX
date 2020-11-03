class Dummy {
    @Override
    public void setUpdateGameList(ArrayList<String> gameList) {
        String sql = "update nba.system set updategamelist=" + result + " where seasonid=12-13";
        String result = new String();
        for (String game : gameList) {
            result += (game + ";");
        }
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
