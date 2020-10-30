public class Dummy{
public String getSalt(long mid) {
    String result = "";
    try (Connection conn = factory.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT Salt FROM users WHERE MID=?")) {
        stmt.setObject(1, mid);
        ResultSet rs = stmt.executeQuery();
        result = rs.next() ? rs.getString(1) : generateRandomSalt();
    } catch (SQLException e) {
        result = generateRandomSalt();
    }
    return result;
}}

