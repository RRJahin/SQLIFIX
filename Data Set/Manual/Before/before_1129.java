public class Dummy{
@Override
public int deleteTeamsByLeader(int leaderId) {
    int result = -1;
    String query = "DELETE FROM Team WHERE leaderId= '" + leaderId + "'";
    System.out.println("Delete query: " + query);
    try {
        Statement stmt = con.createStatement();
        stmt.setQueryTimeout(5);
        result = stmt.executeUpdate(query);
        stmt.close();
    } catch (SQLException e) {
        System.out.println("Delete exception: " + e);
    }
    return (result);
}}

