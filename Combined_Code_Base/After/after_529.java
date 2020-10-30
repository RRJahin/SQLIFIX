public class Dummy{
public void customerCheck(Customer customer) throws SQLException {
    Connection conn = ConnectionUtil.getConnection();
    String purchaseId1 = "SELECT customer_purchase_ID FROM customer_login WHERE customer_username = ?";
    PreparedStatement prepareUsername = conn.prepareStatement(purchaseId1);
    prepareUsername.setObject(1, customer.getUsername());
    ResultSet result1 = prepareUsername.executeQuery();
    String usernameid = "", passwordid = "";
    while (result1.next()) usernameid = String.valueOf(result1.getString(1));
    String purchaseId2 = "SELECT customer_purchase_ID FROM customer_login WHERE customer_password = ?";
    PreparedStatement preparePassword = conn.prepareStatement(purchaseId2);
    preparePassword.setObject(1, customer.getPassword());
    ResultSet result2 = preparePassword.executeQuery();
    while (result2.next()) passwordid = String.valueOf(result2.getString(1));
    if (usernameid.equals(passwordid))
        System.out.print("Welcome " + customer.getUsername());
}}

