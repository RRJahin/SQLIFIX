class Dummy{
@Override
public long login(String username, String password) {
    String sql = "SELECT username, user_id FROM logins where username=" + "'" + username + "'";
    Connection con = ConnectionConfiguration.getConnection();
    try {
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        while (rs.next()) {
            userId = rs.getInt("user_id");
        }
        rs.close();
        stm.close();
    } catch (SQLException e1) {
        e1.printStackTrace();
    }
    return userId;
}}

