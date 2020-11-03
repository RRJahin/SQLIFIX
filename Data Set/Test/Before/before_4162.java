class Dummy{
public static String get_customer_id() {
    try {
        c = ShopNow.openDB();
        stmt = c.createStatement();
        String sql = "SELECT ID FROM CUSTOMER WHERE EMAIL = '" + Login.sendUsername() + "'";
        ResultSet rs = stmt.executeQuery(sql);
        String id = rs.getString(1);
        ShopNow.closeDB();
        return id;
    } catch (Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
        System.exit(0);
    }
    return null;
}}

