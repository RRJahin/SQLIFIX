public class Dummy{
@Override
public int updatePerson(Person prs) {
    int rc = -1;
    String query = "UPDATE Person SET " + "name='" + prs.getName() + "', " + "zipcode='" + prs.getZipcode() + "', " + "country='" + prs.getCountry() + "', " + "address='" + prs.getAddress() + "', " + "phoneNo='" + prs.getPhoneNo() + "', " + "email='" + prs.getEmail() + "', " + "personType='" + prs.getPersonType() + "', " + "password='" + prs.getPassword() + "' " + "WHERE id='" + prs.getId() + "'";
    System.out.println("Update query: " + query);
    try {
        Statement stmt = con.createStatement();
        stmt.setQueryTimeout(5);
        rc = stmt.executeUpdate(query);
        stmt.close();
    } catch (Exception e) {
        System.out.println("Update exception: " + e);
    }
    return rc;
}}

