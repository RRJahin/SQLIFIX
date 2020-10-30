public class Dummy{
public String getRole(long mid, String role) throws ITrustException, DBException {
    try (Connection conn = factory.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT role FROM users WHERE MID=? AND Role=?")) {
        ps.setObject(1, mid);
        ps.setObject(2, role);
        ResultSet rs;
        rs = ps.executeQuery();
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

