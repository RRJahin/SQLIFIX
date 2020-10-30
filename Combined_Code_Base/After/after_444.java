import java.sql.PreparedStatement;

public class Dummy{
@Override
public int updatePerson(Person prs) {
    int rc = -1;
    String query = "UPDATE Person SET " + "name='?', " + "zipcode='?', " + "country='?', " + "address='?', " + "phoneNo='?', " + "email='?', " + "personType='?', " + "password='?' " + "WHERE id='?'";
    System.out.println("Update query: " + query);
    try {
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setQueryTimeout(5);
        stmt.setObject(1, prs.getName());
        stmt.setObject(2,prs.getZipcode());
        stmt.setObject(3,prs.getCountry());
        stmt.setObject(4,prs.getAddress());
        stmt.setObject(5,prs.getPhoneNo());
        stmt.setObject(6,prs.getEmail());
        stmt.setObject(7,prs.getPersonType());
        stmt.setObject(8,prs.getPassword());
        stmt.setObject(9,prs.getId());

        rc = stmt.executeUpdate();
        stmt.close();
    } catch (Exception e) {
        System.out.println("Update exception: " + e);
    }
    return rc;
}}

