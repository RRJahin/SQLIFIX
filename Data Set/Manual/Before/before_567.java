class Dummy{
public static String get_phone_number() {
    try {
        c = ShopNow.openDB();
        stmt = c.createStatement();
        String sql = "SELECT PHONE FROM CUSTOMER WHERE EMAIL = '" + Login.sendUsername() + "'";
        ResultSet rs = stmt.executeQuery(sql);
        ;
        phone_number = rs.getString(1);
        ShopNow.closeDB();
        return phone_number;
    } catch (Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
        System.exit(0);
    }
    return null;
}}

