public class Dummy{
public void placeOrder(Order order) throws SQLException {
    Connection conn = ConnectionUtil.getConnection();
    int stock = 0;
    String qty = "Select product_stock from product_sms where product_id = ?";
    PreparedStatement prepareStock = conn.prepareStatement(qty);
    prepareStock.setObject(1, order.getItemName());
    ResultSet resultStock = prepareStock.executeQuery();
    while (resultStock.next()) stock = Integer.parseInt(String.valueOf(resultStock.getString(1)));
    int totalQuantity = stock - order.getQuantity();
    if (totalQuantity > 0) {
        String updateOrder = "Update product_sms set product_stock = ? where product_id = ?";
        PreparedStatement prepareOrder = conn.prepareStatement(updateOrder);
        prepareOrder.setObject(1, totalQuantity);
        prepareOrder.setObject(2, order.getItemName());
        int resultOrder = prepareOrder.executeUpdate();
        System.out.print(resultOrder + " updated");
    } else {
        System.out.println("Only " + stock + " stock is avaialable");
    }
}}

