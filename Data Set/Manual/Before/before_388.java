public class Dummy{
public void placeOrder(Order order) throws SQLException {
    Connection conn = ConnectionUtil.getConnection();
    int stock = 0;
    String qty = "Select product_stock from product_sms where product_id = "+order.getItemName();
    Statement prepareStock = conn.createStatement();
    ResultSet resultStock = prepareStock.executeQuery(qty);
    while (resultStock.next()) stock = Integer.parseInt(String.valueOf(resultStock.getString(1)));
    int totalQuantity = stock - order.getQuantity();
    if (totalQuantity > 0) {
        String updateOrder = "Update product_sms set product_stock = ? where product_id = ?";
        Statement prepareOrder = conn.createStatement(updateOrder);
        prepareOrder.setInt(1, totalQuantity);
        prepareOrder.setString(2, order.getItemName());
        int resultOrder = prepareOrder.executeUpdate();
        System.out.print(resultOrder + " updated");
    } else {
        System.out.println("Only " + stock + " stock is avaialable");
    }
}}

