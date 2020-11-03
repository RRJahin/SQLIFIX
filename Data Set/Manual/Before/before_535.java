public class Dummy{
public String get_address() {
    try {
        c = ShopNow.openDB();
        stmt = c.createStatement();
        String sql = "SELECT ADDRESS FROM CUSTOMER WHERE EMAIL = '" + Login.sendUsername() + "'";
        ResultSet rs = stmt.executeQuery(sql);
        ;
        address = rs.getString(1);
        ShopNow.closeDB();
        return address;
    } catch (Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
        System.exit(0);
    }
    return null;
}}

