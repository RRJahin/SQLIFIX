public class Dummy{
public String getName(long mid) throws ITrustException, DBException {
    try (Connection conn = factory.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT firstName, lastName FROM patients WHERE MID=?")) {
        ps.setObject(1, mid);
        ResultSet rs;
        rs = ps.executeQuery();
        if (rs.next()) {
            String result = rs.getString("firstName") + " " + rs.getString("lastName");
            rs.close();
            return result;
        } else {
            rs.close();
            throw new ITrustException("User does not exist");
        }
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

