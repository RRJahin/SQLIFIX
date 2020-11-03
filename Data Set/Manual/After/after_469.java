public class Dummy{
@Override
public int deleteTravelAgencyByCvr(int cvr) {
    int rc = -1;
    String query = "DELETE FROM TravelAgency WHERE cvr= '?'";
    System.out.println("Delete query: " + query);
    try {
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setQueryTimeout(5);
        stmt.setObject(1,cvr);
        rc = stmt.executeUpdate();
        stmt.close();
    } catch (SQLException ex) {
        System.out.println("Delete exception: " + ex);
    }
    return (rc);
}}

