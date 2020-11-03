public class Dummy{
public boolean addRepresentative(long representer, long representee) throws DBException, ITrustException {
    try (Connection conn = factory.getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO representatives(RepresenterMID,RepresenteeMID) VALUES (?,?)")) {
        ps.setObject(1, representer);
        ps.setObject(2, representee);
        boolean successfullyAdded = ps.executeUpdate() == 1;
        return successfullyAdded;
    } catch (SQLException e) {
        if (e.getErrorCode() == 1062) {
            throw new ITrustException("Patient " + representer + " already represents patient " + representee);
        } else {
            throw new DBException(e);
        }
    }
}}

