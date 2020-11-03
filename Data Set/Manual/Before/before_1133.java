public class Dummy{
@Override
public int deleteTeamParticipant(int teamId, int participantId) {
    int result = -1;
    String query = "DELETE FROM TeamParticipants WHERE teamId= '" + teamId + "'" + " AND participantId= '" + participantId + "'";
    System.out.println("Delete query: " + query);
    try {
        Statement stmt = con.createStatement();
        stmt.setQueryTimeout(5);
        result = stmt.executeUpdate(query);
        stmt.close();
    } catch (SQLException e) {
        System.out.println("Delete exception: " + e);
    }
    return (result);
}}

