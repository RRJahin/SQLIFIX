public class Dummy{
public static Boolean check_order() {
    String id = Change_Payment.get_customer_id();
    try {
        c = ShopNow.openDB();
        stmt = c.createStatement();
        String sql = "SELECT * FROM HISTORY WHERE CUSTOMER_ID = " + id;
        ResultSet rs = stmt.executeQuery(sql);
        ShopNow.closeDB();
        return rs.next();
    } catch (Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
        System.exit(0);
    }
    return false;
}}

