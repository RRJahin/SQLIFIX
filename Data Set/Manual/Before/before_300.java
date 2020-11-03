public class Dummy{
public void removeAllRepresented(long representerMID) throws DBException {
    try (Connection conn = factory.getConnection();
        Statement updateStatement = conn.createStatement();
        Statement deleteStatement = conn.createStatement()) {
        updateStatement.executeUpdate("UPDATE users U, representatives R SET U.isDependent=0 WHERE R.representerMID="+representerMID+" AND " + "R.representeeMID=U.MID AND R.representeeMID NOT IN " + "(SELECT representeeMID FROM representatives WHERE representerMID<>"+representerMID+")");
        deleteStatement.executeUpdate("DELETE FROM representatives WHERE representerMID="+representerMID);
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

