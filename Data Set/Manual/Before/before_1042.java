public class Dummy{
public String getSalt(long mid) {
    String result = "";
    try (Connection conn = factory.getConnection();
        Statement stmt = conn.createStatement()) {
        ResultSet rs = stmt.executeQuery("SELECT Salt FROM users WHERE MID="+mid);
        result = rs.next() ? rs.getString(1) : generateRandomSalt();
    } catch (SQLException e) {
        result = generateRandomSalt();
    }
    return result;
}}

