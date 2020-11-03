public class Dummy{
@Override
public int insertTravelAgency(TravelAgency travelAgency) throws Exception {
    int rc = -1;
    String query = "INSERT INTO TravelAgency(cvr, name, zipcode, country, address, phoneNo, email) VALUES('?','?','?','?','?','?','?')";
    System.out.println("Insertion query: " + query);
    try {
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setQueryTimeout(5);
        stmt.setObject(1,travelAgency.getCVR() );
        stmt.setObject(2,travelAgency.getName());
        stmt.setObject(3,travelAgency.getZipCode());
        stmt.setObject(4,travelAgency.getCountry());
        stmt.setObject(5,travelAgency.getAddress());
        stmt.setObject(6,travelAgency.getPhoneNo() );
        stmt.setObject(7,travelAgency.getEmail());
        rc = stmt.executeUpdate();
        stmt.close();
    } catch (SQLException ex) {
        System.out.println("Insertion exception: " + ex);
    }
    return rc;
}}

