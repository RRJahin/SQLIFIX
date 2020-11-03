public class Dummy{
@Override
public int updateUserInfo(String id, String pw, String email, String cpw) throws SQLException {
    Connection con = null;
    PreparedStatement ps = null;
    String sql = "update userinfo set pw=?, email=? where id=? and pw=?";
    int result = 0;
    try {
        con = DbUtil.getConnection();
        ps = con.prepareStatement(sql);
        ps.setObject(1, cpw);
        ps.setObject(2, email);
        ps.setObject(3, id);
        ps.setObject(4, pw);
        result = ps.executeUpdate();
    } finally {
        DbUtil.dbClose(con, ps);
    }
    return result;
}}

