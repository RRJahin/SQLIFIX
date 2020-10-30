public class Dummy{
public void removeAllRepresented(long representerMID) throws DBException {
    try (Connection conn = factory.getConnection();
        PreparedStatement updateStatement = conn.prepareStatement("UPDATE users U, representatives R SET U.isDependent=0 WHERE R.representerMID=? AND " + "R.representeeMID=U.MID AND R.representeeMID NOT IN " + "(SELECT representeeMID FROM representatives WHERE representerMID<>?)");
        PreparedStatement deleteStatement = conn.prepareStatement("DELETE FROM representatives WHERE representerMID=?")) {
        updateStatement.setObject(1, representerMID);
        updateStatement.setObject(2, representerMID);
        updateStatement.executeUpdate();
        deleteStatement.setObject(1, representerMID);
        deleteStatement.executeUpdate();
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

