public class Dummy{
@Override
public int insertTeamParticipant(Participant teamParticipant) throws Exception {
    int result = -1;
    String query = "INSERT INTO TeamParticipants(teamId, participantId) VALUES ('" + teamParticipant.getTeam().getId() + "','" + teamParticipant.getGuest().getId() + "')";
    System.out.println("Insertiion query: " + query);
    try {
        Statement stmt = con.createStatement();
        stmt.setQueryTimeout(5);
        result = stmt.executeUpdate(query);
        stmt.close();
    } catch (SQLException e) {
        System.out.println("Insertion exception: " + e);
    }
    return (result);
}}

