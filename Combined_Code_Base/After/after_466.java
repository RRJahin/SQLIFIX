public class Dummy{
@Override
public int getTeamParticipantInstances(int teamId, int participantId) {
    int instances = 0;
    ResultSet results;
    String query = "SELECT COUNT(*) AS teamParticipantInstances FROM TeamParticipants " + " WHERE teamId='?' AND participantId='?'";
    System.out.println(query);
    try {
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setQueryTimeout(5);
        stmt.setObject(1,teamId);
        stmt.setObject(2,participantId);
        results = stmt.executeQuery();
        while (results.next()) {
            instances = results.getInt("teamParticipantInstances");
            System.out.println("Team participant instances: " + instances);
        }
        stmt.close();
    } catch (Exception e) {
        System.out.println("Exception in returning the team participant instance count: " + e);
    }
    return instances;
}}

