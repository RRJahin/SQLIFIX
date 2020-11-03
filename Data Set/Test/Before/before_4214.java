class Dummy{
public Address getAddress(String addressId) {
    try {
        Statement st = DBHelper.getConnection().createStatement();
        String selectAddressQuery = "SELECT AddressID, StreetName, ApartmentNumber, City, State, Zip FROM Address WHERE AddressID = '" + addressId + "'";
        ResultSet addrRS = st.executeQuery(selectAddressQuery);
        System.out.println("RenterDAO: *************** Query " + selectAddressQuery);
        Address address = new Address();
        while (addrRS.next()) {
            address.setAddressID(addrRS.getString("AddressID"));
            address.setStreetName(addrRS.getString("StreetName"));
            address.setApartmentNumber(addrRS.getString("ApartmentNumber"));
            address.setCity(addrRS.getString("City"));
            address.setState(addrRS.getString("State"));
            address.setZip(addrRS.getString("Zip"));
        }
        addrRS.close();
        return address;
    } catch (SQLException se) {
        System.err.println("RenterDAO: Threw a SQLException retrieving the address object.");
        System.err.println(se.getMessage());
        se.printStackTrace();
    }
    return null;
}}

