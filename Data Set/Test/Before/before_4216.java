class Dummy{
public Renter getRenter(int renterId) {
    try {
        Statement st = DBHelper.getConnection().createStatement();
        String selectRenterQuery = "SELECT RenterID, LastName, FirstName, AddressID FROM Renter WHERE RenterID = '" + renterId + "'";
        ResultSet renterRS = st.executeQuery(selectRenterQuery);
        System.out.println("RenterDAO: *************** Query " + selectRenterQuery);
        Renter renter = new Renter();
        while (renterRS.next()) {
            renter.setRenterId(renterRS.getInt("RenterID"));
            renter.setLastName(renterRS.getString("LastName"));
            renter.setFirstName(renterRS.getString("FirstName"));
            renter.setRentingAddress(getAddress(renterRS.getString("AddressID")));
        }
        renterRS.close();
        st.close();
        return renter;
    } catch (SQLException se) {
        System.err.println("RenterDAO: Threw a SQLException retrieving the address object.");
        System.err.println(se.getMessage());
        se.printStackTrace();
    }
    return null;
}}

