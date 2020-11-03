class Dummy{
public Boolean payment_exists() {
    String customer_id = get_customer_id();
    try {
        c = ShopNow.openDB();
        stmt = c.createStatement();
        String sql = "SELECT * FROM PAYMENT WHERE CUSTOMER_ID = " + customer_id;
        ResultSet rs = stmt.executeQuery(sql);
        ShopNow.closeDB();
        return rs.next();
    } catch (Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
        System.exit(0);
    }
    return false;
}}

