public class Dummy{
@Override
public int getTeamParticipantInstances(int teamId, int participantId) {
    int instances = 0;
    ResultSet results;
    String query = "SELECT COUNT(*) AS teamParticipantInstances FROM TeamParticipants " + " WHERE teamId='" + teamId + "' AND participantId='" + participantId + "'";
    System.out.println(query);
    try {
        Statement stmt = con.createStatement();
        stmt.setQueryTimeout(5);
        results = stmt.executeQuery(query);
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

