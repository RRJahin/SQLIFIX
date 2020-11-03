import java.sql.PreparedStatement;

public class Dummy{
@Override
public int updateTravelAgency(TravelAgency travelAgency) {
    int rc = -1;
    TravelAgency travelAgencytravelAgency = travelAgency;
    String query = "UPDATE TravelAgency SET " + "name='?', " + "zipcode='?', " + "country='?', " + "address='?', " + "phoneNo='?', " + "email='?' " + "WHERE cvr='?'";
    System.out.println("Update query: " + query);
    try {
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setQueryTimeout(5);
        stmt.setObject(1,travelAgencytravelAgency.getName() );
        stmt.setObject(2,travelAgencytravelAgency.getZipCode() );
        stmt.setObject(3,travelAgencytravelAgency.getCountry() );
        stmt.setObject(4,travelAgencytravelAgency.getAddress());
        stmt.setObject(5,travelAgencytravelAgency.getPhoneNo() );
        stmt.setObject(6,travelAgencytravelAgency.getEmail());
        stmt.setObject(7,travelAgencytravelAgency.getCVR());
        rc = stmt.executeUpdate();
        stmt.close();
    } catch (SQLException e) {
        System.out.println("Update exception: " + e);
    }
    return rc;
}}

