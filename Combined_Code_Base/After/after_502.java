public class Dummy{
public static BigInteger getStarwoodMemberId(Connection conn, String userName) throws SQLException {
    BigInteger id = BigInteger.valueOf(-1);
    String sql = "Select Id  from Starwood a " + " where a.User_name = ? ";
    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setObject(1, userName);
    ResultSet rs = pstm.executeQuery();
    if (rs.next()) {
        id = BigInteger.valueOf(rs.getLong("Id"));
    }
    return id;
}}

