public class Dummy{
@Override
public CustomerResponse fetchCustomer(final CustomerFetchParams customerFetchParams) throws SQLException {
    Connection con = null;
    Statement stmt = null;
    Customer customer = new Customer();
    ResultSet resultSet = null;
    try {
        con = DriverManager.getConnection("jdbc:mysql://35.196.69.15:3306/CRM?user=sanjay&password=sanjay");
        String query = "SELECT * FROM CUSTOMER WHERE CUSTOMER_ID="+customerFetchParams.getCustomerId();
        stmt = con.createStatement();
        resultSet = stmt.executeQuery(query);
        customer.setCustomerId(resultSet.getLong("CUSTOMER_ID"));
        customer.setMobileNumber(resultSet.getLong("MOBILE_NUMBER"));
        customer.setName(resultSet.getString("NAME"));
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
            resultSet.close();
        }
    }
    return this.customerToCustomerResponse(customer);
}}

