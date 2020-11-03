public class Dummy{
public String getName(long mid) throws ITrustException, DBException {
    try (Connection conn = factory.getConnection();
        Statement ps = conn.createStatement()) {
        ResultSet rs;
        rs = ps.executeQuery("SELECT firstName, lastName FROM patients WHERE MID="+mid);
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

