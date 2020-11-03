public class Dummy{
public int getPrice(Order order) throws SQLException {
    Connection conn = ConnectionUtil.getConnection();
    String bookCost = "Select product_price from product_sms where product_id = "+order.getItemName();
    Statement prepareCost = conn.createStatement();
    ResultSet result = prepareCost.executeQuery(bookCost);
    int value = 0;
    while (result.next()) value = Integer.parseInt(String.valueOf(result.getString(1)));
    return value;
}}

