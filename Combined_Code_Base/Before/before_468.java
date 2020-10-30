public class Dummy{
@Override
public int updateTravelAgency(TravelAgency travelAgency) {
    int rc = -1;
    TravelAgency travelAgencytravelAgency = travelAgency;
    String query = "UPDATE TravelAgency SET " + "name='" + travelAgencytravelAgency.getName() + "', " + "zipcode='" + travelAgencytravelAgency.getZipCode() + "', " + "country='" + travelAgencytravelAgency.getCountry() + "', " + "address='" + travelAgencytravelAgency.getAddress() + "', " + "phoneNo='" + travelAgencytravelAgency.getPhoneNo() + "', " + "email='" + travelAgencytravelAgency.getEmail() + "' " + "WHERE cvr='" + travelAgencytravelAgency.getCVR() + "'";
    System.out.println("Update query: " + query);
    try {
        Statement stmt = con.createStatement();
        stmt.setQueryTimeout(5);
        rc = stmt.executeUpdate(query);
        stmt.close();
    } catch (SQLException e) {
        System.out.println("Update exception: " + e);
    }
    return rc;
}}

