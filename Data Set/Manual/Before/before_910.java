public class Dummy{
public void dynamic_display() {
    Boolean check = check_order();
    String id = Change_Payment.get_customer_id();
    if (check == true) {
        try {
            c = ShopNow.openDB();
            stmt = c.createStatement();
            String sql = "SELECT ITEM_NAME,QUANTITY,PRICE FROM HISTORY WHERE CUSTOMER_ID = " + id + " ORDER BY ORDER_ID DESC";
            ResultSet rs = stmt.executeQuery(sql);
            int i = 0;
            while (rs.next()) {
                String result = rs.getString(1);
                String result2 = rs.getString(2);
                String result3 = rs.getString(3);
                resultList.add(Arrays.asList(result, result2, result3));
                System.out.println("NAME: " + result + " Quantity: " + result2 + " PRICE: " + result3);
            }
            ShopNow.closeDB();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    } else {
        JOptionPane.showMessageDialog(null, "This Customer has not made any orders yet!");
    }
}}

