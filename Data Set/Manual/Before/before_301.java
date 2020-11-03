public class Dummy{
public void removeAllRepresentee(long representeeMID) throws DBException {
    try (Connection conn = factory.getConnection();
        Statement deleteStatement = conn.createStatement();
        Statement updateStatement = conn.createStatement()) {
        deleteStatement.executeUpdate("DELETE FROM representatives WHERE representeeMID="+representeeMID);
        updateStatement.executeUpdate("UPDATE users SET isDependent=0 WHERE MID="+representeeMID);
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

