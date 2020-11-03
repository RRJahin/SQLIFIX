class Dummy{
public static Customer getDepositChech(String accountNum) throws SQLException {
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
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Proble Occur.Try Again ");
    }
    return customer;
}}

