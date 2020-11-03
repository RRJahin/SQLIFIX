public class Dummy{
@Override
public int deleteTeamParticipants(int teamId) {
    int result = -1;
    String query = "DELETE FROM TeamParticipants WHERE teamId= '?'";
    System.out.println("Delete query: " + query);
    try {
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setQueryTimeout(5);
        stmt.setObject(1,teamId);
        result = stmt.executeUpdate();
        stmt.close();
    } catch (SQLException e) {
        System.out.println("Delete exception: " + e);
    }
    return (result);
}}
