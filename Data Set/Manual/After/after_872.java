public class Dummy{
public boolean addNDCode(MedicationBean med) throws DBException, ITrustException {
    try (Connection conn = factory.getConnection();
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO ndcodes (Code, Description) " + "VALUES (?,?)")) {
        stmt.setObject(1, med.getNDCode());
        stmt.setObject(2, med.getDescription());
        boolean successfullyAdded = stmt.executeUpdate() == 1;
        return successfullyAdded;
    } catch (SQLException e) {
        if (e.getErrorCode() == 1062) {
            throw new ITrustException("Error: Code already exists.");
        } else {
            throw new DBException(e);
        }
    }
}}

