import java.sql.PreparedStatement;

public class Dummy{
@Override
public int insertTeam(Team team) throws Exception {
    int nextTeamId = GetMax.getMaxId("SELECT MAX(teamId) FROM Team");
    nextTeamId = nextTeamId + 1;
    System.out.println("Next team id = " + nextTeamId);
    int result = -1;
    Guest guestObj = team.getLeader();
    String query = "INSERT INTO Team(teamId, leaderId, numberOfParticipants) VALUES ('?','?','?') INSERT INTO TeamParticipants(teamId, participantId)  VALUES ('?','?')";
    System.out.println("Insertion query: " + query);
    try {
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setQueryTimeout(5);
        stmt.setObject(1,nextTeamId );
        stmt.setObject(2,guestObj.getId());
        stmt.setObject(3,team.getNumberOfParticipants());
        stmt.setObject(4,nextTeamId );
        stmt.setObject(5, guestObj.getId());
        result = stmt.executeUpdate();
        stmt.close();
    } catch (SQLException e) {
        System.out.println("Insert exception: " + e);
    }
    return (result);
}}

