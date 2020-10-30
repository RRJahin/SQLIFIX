public class Dummy{
public static Boolean check_order() {
    String id = Change_Payment.get_customer_id();
    try {
        c = ShopNow.openDB();
        String sql = "SELECT * FROM HISTORY WHERE CUSTOMER_ID = ?";
        stmt = c.prepareStatement(sql);
        stmt.setObject(1,id);
        ResultSet rs = stmt.executeQuery();
        ShopNow.closeDB();
        return rs.next();
    } catch (Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
        System.exit(0);
    }
    return false;
}}

