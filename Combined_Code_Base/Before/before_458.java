public class Dummy{
@Override
public int insertTeam(Team team) throws Exception {
    int nextTeamId = GetMax.getMaxId("SELECT MAX(teamId) FROM Team");
    nextTeamId = nextTeamId + 1;
    System.out.println("Next team id = " + nextTeamId);
    int result = -1;
    Guest guestObj = team.getLeader();
    String query = "INSERT INTO Team(teamId, leaderId, numberOfParticipants) VALUES ('" + nextTeamId + "','" + guestObj.getId() + "','" + team.getNumberOfParticipants() + "') INSERT INTO TeamParticipants(teamId, participantId) VALUES ('" + nextTeamId + "','" + guestObj.getId() + "')";
    System.out.println("Insertion query: " + query);
    try {
        Statement stmt = con.createStatement();
        stmt.setQueryTimeout(5);
        result = stmt.executeUpdate(query);
        stmt.close();
    } catch (SQLException e) {
        System.out.println("Insert exception: " + e);
    }
    return (result);
}}

