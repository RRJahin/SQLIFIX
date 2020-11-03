public class Dummy{
public String get_address() {
    try {
        c = ShopNow.openDB();

        String sql = "SELECT ADDRESS FROM CUSTOMER WHERE EMAIL = ?";
        stmt = c.prepareStatement(sql);
        stmt.setObject(1,Login.sendUsername() );
        ResultSet rs = stmt.executeQuery();
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

