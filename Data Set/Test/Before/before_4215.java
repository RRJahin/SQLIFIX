class Dummy{
public void removeAddress(String addressId) {
    try {
        Statement st = DBHelper.getConnection().createStatement();
        String buildingRemovalQuery = "delete from Building where AddressID = '" + addressId + "'";
        st.execute(buildingRemovalQuery);
        st.close();
    } catch (SQLException e) {
        System.err.println("RenterDAO: error removing address primary key references");
        System.err.println(e.getMessage());
    }
    try {
        Statement st = DBHelper.getConnection().createStatement();
        String renterRemovalQuery = "delete from Renter where AddressID = '" + addressId + "'";
        st.execute(renterRemovalQuery);
        st.close();
    } catch (SQLException e) {
        System.err.println("RenterDAO: error removing address primary key references");
        System.err.println(e.getMessage());
    }
    try {
        Statement st = DBHelper.getConnection().createStatement();
        String facilityRemovalQuery = "delete from Address where AddressID = '" + addressId + "'";
        st.execute(facilityRemovalQuery);
        st.close();
    } catch (SQLException e) {
        System.err.println("RenterDAO: Threw and SQLException while trying to delete address");
        System.err.println(e.getMessage());
    }
}}

