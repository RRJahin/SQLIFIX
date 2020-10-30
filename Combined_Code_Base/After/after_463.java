public class Dummy{
@Override
public int insertTeamParticipant(Participant teamParticipant) throws Exception {
    int result = -1;
    String query = "INSERT INTO TeamParticipants(teamId, participantId) VALUES ('?','?')";
    System.out.println("Insertiion query: " + query);
    try {
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setQueryTimeout(5);
        stmt.setObject(1,teamParticipant.getTeam().getId() );
        stmt.setObject(2,teamParticipant.getGuest().getId());
        result = stmt.executeUpdate();
        stmt.close();
    } catch (SQLException e) {
        System.out.println("Insertion exception: " + e);
    }
    return (result);
}}

