public class Dummy{
public void customerCheck(Customer customer) throws SQLException {
    Connection conn = ConnectionUtil.getConnection();
    String purchaseId1 = "SELECT customer_purchase_ID FROM customer_login WHERE customer_username = "+customer.getUsername();
    Statement prepareUsername = conn.createStatement();
    ResultSet result1 = prepareUsername.executeQuery(purchaseId1);
    String usernameid = "", passwordid = "";
    while (result1.next()) usernameid = String.valueOf(result1.getString(1));
    String purchaseId2 = "SELECT customer_purchase_ID FROM customer_login WHERE customer_password = "+customer.getPassword();
    Statement preparePassword = conn.createStatement();
    ResultSet result2 = preparePassword.executeQuery(purchaseId2);
    while (result2.next()) passwordid = String.valueOf(result2.getString(1));
    if (usernameid.equals(passwordid))
        System.out.print("Welcome " + customer.getUsername());
}}

