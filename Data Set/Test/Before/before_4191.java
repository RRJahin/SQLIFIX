class Dummy{
public static Customer withdrawCheck(String accountNum) throws SQLException {
    ResultSet rs = null;
    Statement stat = null;
    Customer customer = null;
    try {
        stat = myConn.createStatement();
        rs = stat.executeQuery("SELECT * FROM register_customer WHERE Account_num ='" + accountNum + "'");
        while (rs.next()) {
            System.out.println("OK");
            customer = convertToEmployee(rs);
        }
    } finally {
    }
    return customer;
}}

