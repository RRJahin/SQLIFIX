public class Dummy{
public void removeAllRepresentee(long representeeMID) throws DBException {
    try (Connection conn = factory.getConnection();
        PreparedStatement deleteStatement = conn.prepareStatement("DELETE FROM representatives WHERE representeeMID=?");
        PreparedStatement updateStatement = conn.prepareStatement("UPDATE users SET isDependent=0 WHERE MID=?")) {
        deleteStatement.setObject(1, representeeMID);
        deleteStatement.executeUpdate();
        updateStatement.setObject(1, representeeMID);
        updateStatement.executeUpdate();
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

