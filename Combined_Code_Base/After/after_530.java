public class Dummy{
public void customerRegister(Register register) throws SQLException {
    Connection conn = ConnectionUtil.getConnection();
    System.out.println("Welcome to Registration Page");
    String insertCustomer = "Insert into customer_login (customer_username, customer_password, customer_age, customer_since_from, customer_purchase_id, customer_address, customer_pincode)" + "values (?,?,?,?,?,?,?)";
    PreparedStatement prepareRegister = conn.prepareStatement(insertCustomer);
    prepareRegister.setObject(1, register.getUsername());
    prepareRegister.setObject(2, register.getPassword());
    prepareRegister.setObject(3, register.getAge());
    prepareRegister.setObject(4, register.getSinceFrom());
    prepareRegister.setObject(5, register.getPurchaseId());
    prepareRegister.setObject(6, register.getAddress());
    prepareRegister.setObject(7, register.getPincode());
    int result = prepareRegister.executeUpdate();
    System.out.print(result + " Affected");
}}

