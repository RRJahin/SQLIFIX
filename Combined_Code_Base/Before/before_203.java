public class Dummy{
public boolean addNDCode(MedicationBean med) throws DBException, ITrustException {
    try (Connection conn = factory.getConnection();
        Statement stmt = conn.createStatement()) {
        boolean successfullyAdded = stmt.executeUpdate("INSERT INTO ndcodes (Code, Description) " + "VALUES ("+med.getNDCode()+","+med.getDescription()+")") == 1;
        return successfullyAdded;
    } catch (SQLException e) {
        if (e.getErrorCode() == 1062) {
            throw new ITrustException("Error: Code already exists.");
        } else {
            throw new DBException(e);
        }
    }
}}

