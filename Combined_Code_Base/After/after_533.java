public class Dummy{
public static String get_name() {
    try {
        c = ShopNow.openDB();
        
        String sql = "SELECT FIRST_NAME,LAST_NAME FROM CUSTOMER WHERE EMAIL = ?";
        stmt = c.prepareStatement(sql);
        stmt.setObject(1,Login.sendUsername() );
        ResultSet rs = stmt.executeQuery();
        ;
        user_name = rs.getString(1) + " " + rs.getString(2);
        ShopNow.closeDB();
        return user_name;
    } catch (Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
        System.exit(0);
    }
    return null;
}}

