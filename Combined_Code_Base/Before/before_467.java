public class Dummy{
@Override
public int insertTravelAgency(TravelAgency travelAgency) throws Exception {
    int rc = -1;
    String query = "INSERT INTO TravelAgency(cvr, name, zipcode, country, address, phoneNo, email) VALUES('" + travelAgency.getCVR() + "','" + travelAgency.getName() + "','" + travelAgency.getZipCode() + "','" + travelAgency.getCountry() + "','" + travelAgency.getAddress() + "','" + travelAgency.getPhoneNo() + "','" + travelAgency.getEmail() + "')";
    System.out.println("Insertion query: " + query);
    try {
        Statement stmt = con.createStatement();
        stmt.setQueryTimeout(5);
        rc = stmt.executeUpdate(query);
        stmt.close();
    } catch (SQLException ex) {
        System.out.println("Insertion exception: " + ex);
    }
    return rc;
}}

