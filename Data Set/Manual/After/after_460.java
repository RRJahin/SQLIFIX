public class Dummy{
@Override
public int deleteTeamsByLeader(int leaderId) {
    int result = -1;
    String query = "DELETE FROM Team WHERE leaderId= '?'";
    System.out.println("Delete query: " + query);
    try {
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setQueryTimeout(5);
        stmt.setObjet(1,leaderId);
        result = stmt.executeUpdate();
        stmt.close();
    } catch (SQLException e) {
        System.out.println("Delete exception: " + e);
    }
    return (result);
}}

