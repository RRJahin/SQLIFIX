class Dummy{
public String get_info_dynamically(String info) {
    String customer_id = get_customer_id();
    try {
        c = ShopNow.openDB();
        stmt = c.createStatement();
        String sql = "SELECT " + info + " FROM PAYMENT WHERE CUSTOMER_ID = " + customer_id;
        ResultSet rs = stmt.executeQuery(sql);
        String card = rs.getString(1);
        ShopNow.closeDB();
        return card;
    } catch (Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
        System.exit(0);
    }
    return null;
}}

