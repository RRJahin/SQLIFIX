public class Dummy{
public void customerRegister(Register register) throws SQLException {
    Connection conn = ConnectionUtil.getConnection();
    System.out.println("Welcome to Registration Page");
    String insertCustomer = "Insert into customer_login (customer_username, customer_password, customer_age, customer_since_from, customer_purchase_id, customer_address, customer_pincode)" + "values ("+register.getUsername()+","+register.getPassword()+","+register.getAge()+","+register.getSinceFrom()+","+register.getPurchaseId()+","+register.getAddress()+","+register.getPincode()+")";
    Statement prepareRegister = conn.createStatement(r);
    
    int result = prepareRegister.executeUpdate(insertCustome);
    System.out.print(result + " Affected");
}}

