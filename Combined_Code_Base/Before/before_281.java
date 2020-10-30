public class Dummy{
public String getRole(long mid, String role) throws ITrustException, DBException {
    try (Connection conn = factory.getConnection();
        Statement ps = conn.createStatement()) {
        ResultSet rs;
        rs = ps.executeQuery("SELECT role FROM users WHERE MID="+mid+" AND Role="+role);
        if (rs.next()) {
            String result = rs.getString("role");
            rs.close();
            return result;
        } else {
            rs.close();
            throw new ITrustException("User does not exist with the designated role");
        }
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

