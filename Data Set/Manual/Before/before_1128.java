public class Dummy{
@Override
public int updateTeam(Team team) {
    int result = -1;
    Team teamObj = team;
    Guest guestObj = teamObj.getLeader();
    String query = "UPDATE Team SET leaderId= '" + guestObj.getId() + "', " + "numberOfParticipants= '" + teamObj.getNumberOfParticipants() + "' " + "WHERE teamId= '" + teamObj.getId() + "'";
    System.out.println("Update query: " + query);
    try {
        Statement stmt = con.createStatement();
        stmt.setQueryTimeout(5);
        result = stmt.executeUpdate(query);
        stmt.close();
    } catch (SQLException e) {
        System.out.println("Update exception: " + e);
    }
    return (result);
}}

