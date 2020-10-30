public class Dummy{
@Override
public CustomerResponse addCustomers(final CustomerAddRequest customerAddRequest) throws SQLException {
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    Customer customer = new Customer();
    try {
        con = DriverManager.getConnection("jdbc:mysql://35.196.69.15:3306/CRM?user=sanjay&password=sanjay");
        String query = "INSERT INTO CUSTOMER(NAME,MOBILE_NUMBER) VALUES(?,?)";
        stmt = con.prepareStatement(query);
        stmt.setObject(1, customerAddRequest.getMobileNumber());
        stmt.setObject(2, customerAddRequest.getName());
        int a = stmt.executeUpdate();
        rs = stmt.getGeneratedKeys();
        customer.setCustomerId(rs.getLong("CUSTOMER_ID"));
        customer.setMobileNumber(customerAddRequest.getMobileNumber());
        customer.setName(customerAddRequest.getName());
    } catch (SQLException e) {
        if (con != null) {
            try {
                System.err.print("Transaction is being rolled back");
                con.rollback();
            } catch (SQLException excep) {
            }
        }
    } finally {
        if (stmt != null) {
            stmt.close();
            con.close();
            rs.close();
        }
    }
    return this.customerToCustomerResponse(customer);
}}

