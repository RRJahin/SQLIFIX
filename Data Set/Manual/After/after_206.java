public class Dummy{
public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Enter the customer id:");
    int customerId = keyboard.nextInt();
    System.out.println("Enter the product id:");
    int productId = keyboard.nextInt();
    System.out.println("Enter the product id:");
    int orderId = keyboard.nextInt();
    System.out.println("Enter the product id:");
    int quantity = keyboard.nextInt();
    System.out.println("Enter the product id:");
    double shipCost = keyboard.nextDouble();
    System.out.println("Enter the product id:");
    String salesDate = keyboard.nextLine();
    System.out.println("Enter the product id:");
    String shipDate = keyboard.nextLine();
    System.out.println("Enter the product id:");
    String shipCompany = keyboard.nextLine();
    String sqla = "SELECT CUSTOMER_ID FROM CUSTOMER WHERE customerid = ?";
    String sqlb = "SELECT CUSTOMER_ID, DISCOUNT_CODE, ZIP, NAME, ADDRESSLINE1, " + "ADDRESSLINE2, CITY, STATE, PHONE, FAX, EMAIL, CREDIT_LIMIT  " + "FROM CUSTOMER WHERE CUSTOMER_ID = ?";
    try {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        String jdbc = "jdbc:derby://localhost:1527/sample";
        Connection conn = DriverManager.getConnection(jdbc, "app", "app");
        PreparedStatement statement = conn.prepareStatement(sqla);
        ResultSet rs1 = statement.executeQuery();
        while (rs1.next()) {
            int id = rs1.getInt("CUSTOMER_ID");
            int discount = rs1.getInt("DISCOUNT_CODE");
            int zip = rs1.getInt("ZIP");
            String name = rs1.getString("NAME");
            String address1 = rs1.getString("ADDRESSLINE1");
            String address2 = rs1.getString("ADDRESSLINE2");
            String city = rs1.getString("CITY");
            String state = rs1.getString("STATE");
            String phone = rs1.getString("PHONE");
            String email = rs1.getString("FAX");
            int credit = rs1.getInt("CREDIT_LIMIT");
            System.out.println(id);
            System.out.println(discount);
            System.out.println(zip);
            System.out.println(name);
            System.out.println(address1);
            System.out.println(address2);
            System.out.println(city);
            System.out.println(state);
            System.out.println(phone);
            System.out.println(email);
            System.out.println(credit);
        }
        conn.close();
    } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(NEAssignment3.class.getName()).log(Level.SEVERE, null, ex);
    }
}}

