public class Dummy{
public static Starwood findStarwoodMember(Connection conn, String userName, String password, String key) throws SQLException {
    String sql = "Select * from Members a " + " where a.User_Name = ? ";
    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setObject(1, userName);
    ResultSet rs = pstm.executeQuery();
    if (rs.next()) {
        String pass = rs.getString("User_Password");
        try {
            pass = EncryptDecrypt.decrypt(pass, key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (pass.equals(password)) {
            Starwood member = findStarwoodMember(conn, userName);
            if (member != null) {
                pass = rs.getString("User_Password");
                member.setPassword(pass);
                return member;
            }
        }
    }
    return null;
}}

