public class Dummy{
public static BigInteger getStarwoodMemberId(Connection conn, String userName) throws SQLException {
    BigInteger id = BigInteger.valueOf(-1);
    String sql = "Select Id  from Starwood a " + " where a.User_name = "+userName;
    Statement pstm = conn.createStatement();
    ResultSet rs = pstm.executeQuery(sql);
    if (rs.next()) {
        id = BigInteger.valueOf(rs.getLong("Id"));
    }
    return id;
}}

