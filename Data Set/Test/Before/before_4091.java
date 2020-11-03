class Dummy {
    public String login(String username, String pass) {
        String result = null;
        connection = DBUtil.getConnection();
        String sql = "SELECT TEACHERNAME FROM TEACHER WHERE TEACHERID=" + username + "AND PASSWORD=" + pass;
        try {
            statement = connection.createStatement();
            set = statement.executeQuery(sql);
            if (set != null) {
                if (set.next()) {
                    result = set.getString("TEACHERNAME");
                }
            } else {
                result = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeDB(connection, statement, set);
        }
        return result;
    }
}
