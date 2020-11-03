public class Dummy{
public boolean getDeactivated(final long mid) throws ITrustException {
    final Role role = getUserRole(mid);
    boolean isDeactivated;
    if (role.equals(Role.PATIENT)) {
        try (Connection conn = factory.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT DateOfDeactivation FROM patients WHERE MID=?")) {
            stmt.setObject(1, mid);
            ResultSet results;
            results = stmt.executeQuery();
            if (results.next()) {
                if (results.getString("DateOfDeactivation") == null) {
                    results.close();
                    isDeactivated = false;
                } else {
                    results.close();
                    isDeactivated = true;
                }
            } else {
                throw new ITrustException("User does not exist");
            }
        } catch (SQLException e) {
            throw new DBException(e);
        }
    } else {
        isDeactivated = false;
    }
    return isDeactivated;
}}

