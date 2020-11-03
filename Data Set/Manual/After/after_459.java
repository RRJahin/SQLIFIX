public class Dummy{
@Override
public int updateTeam(Team team) {
    int result = -1;
    Team teamObj = team;
    Guest guestObj = teamObj.getLeader();
    String query = "UPDATE Team SET leaderId= '?', " + "numberOfParticipants= '?' " + "WHERE teamId= '?'";
    System.out.println("Update query: " + query);
    try {
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setQueryTimeout(5);
        stmt.setObject(1,guestObj.getId() );
        stmt.setObject(2,teamObj.getNumberOfParticipants());
        stmt.setObject(3,teamObj.getId());
        result = stmt.executeUpdate();
        stmt.close();
    } catch (SQLException e) {
        System.out.println("Update exception: " + e);
    }
    return (result);
}}

