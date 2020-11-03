public class Dummy{
@Override
public int deleteActivityBooking(int id) {
    int result = -1;
    String query = "DELETE FROM ActivityBooking WHERE id= '?'";
    System.out.println("Delete query: " + query);
    try {
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setQueryTimeout(5);
        stmt.setObject(1,id);
        result = stmt.executeUpdate();
        stmt.close();
    } catch (SQLException e) {
        System.out.println("Delete exception: " + e);
    }
    return (result);
}}

