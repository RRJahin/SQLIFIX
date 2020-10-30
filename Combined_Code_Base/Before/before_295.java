public class Dummy{
public boolean addRepresentative(long representer, long representee) throws DBException, ITrustException {
    try (Connection conn = factory.getConnection();
        Statement ps = conn.createStatement()) {
        boolean successfullyAdded = ps.executeUpdate("INSERT INTO representatives(RepresenterMID,RepresenteeMID) VALUES ("+representer+","+representee+")") == 1;
        return successfullyAdded;
    } catch (SQLException e) {
        if (e.getErrorCode() == 1062) {
            throw new ITrustException("Patient " + representer + " already represents patient " + representee);
        } else {
            throw new DBException(e);
        }
    }
}}

