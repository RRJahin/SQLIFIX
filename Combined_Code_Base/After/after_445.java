public class Dummy{
@Override
public int deletePerson(int prsId) {
    int rc = -1;
    String query = "DELETE FROM Person WHERE id= '?'";
    System.out.println("Delete query: " + query);
    try {
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setQueryTimeout(5);
        stmt.setObject(1,prsId);
        rc = stmt.executeUpdate();
        stmt.close();
    } catch (Exception ex) {
        System.out.println("Delete exception: " + ex);
    }
    return (rc);
}}

