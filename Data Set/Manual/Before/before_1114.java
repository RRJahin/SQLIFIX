public class Dummy{
@Override
public int deletePerson(int prsId) {
    int rc = -1;
    String query = "DELETE FROM Person WHERE id= '" + prsId + "'";
    System.out.println("Delete query: " + query);
    try {
        Statement stmt = con.createStatement();
        stmt.setQueryTimeout(5);
        rc = stmt.executeUpdate(query);
        stmt.close();
    } catch (Exception ex) {
        System.out.println("Delete exception: " + ex);
    }
    return (rc);
}}

