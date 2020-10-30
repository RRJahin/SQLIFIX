public class Dummy{
@Override
public int deleteTeamByBothIDs(int teamId, int leaderId) {
    int result = -1;
    String query = "DELETE FROM Team WHERE teamId= '?' AND leaderId= '?'";
    System.out.println("Delete query: " + query);
    try {
    PreparedStatement stmt = con.prepareStatement(query);
        stmt.setQueryTimeout(5);
        stmt.setObject(1,teamId);
        stmt.setObject(2,leaderId);
        result = stmt.executeUpdate();
        stmt.close();
    } catch (SQLException e) {
        System.out.println("Delete exception: " + e);
    }
    return (result);
}}

