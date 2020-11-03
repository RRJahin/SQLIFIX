public class Dummy{
@Override
public int deleteTravelAgencyByName(String name) {
    int rc = -1;
    String query = "DELETE FROM TravelAgency WHERE name= '" + name + "'";
    System.out.println("Delete query: " + query);
    try {
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setQueryTimeout(5);
        stmt.setObject(1,name);
        rc = stmt.executeUpdate();
        stmt.close();
    } catch (SQLException ex) {
        System.out.println("Delete exception: " + ex);
    }
    return (rc);
}}

