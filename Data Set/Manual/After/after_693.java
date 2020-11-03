public class Dummy{
public static boolean checkUsername(String username) {
    boolean valid = true;
    try {
        c = ShopNow.openDB();
        stmt = c.prepareStatement("SELECT * FROM ADMIN WHERE EMAIL LIKE ?;");
        stmt.setObject(1,username);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            valid = false;
        }
        rs.close();
        stmt.close();
        ShopNow.closeDB();
    } catch (Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
        System.exit(0);
    }
    return valid;
}}

