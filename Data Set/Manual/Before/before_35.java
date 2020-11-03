public class Dummy{
public static boolean emailSearch(String email) {
    boolean result = false;
    try {
        c = ShopNow.openDB();
        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM ADMIN WHERE EMAIL LIKE '" + email + "';");
        while (rs.next()) {
            result = true;
        }
        rs.close();
        stmt.close();
        ShopNow.closeDB();
    } catch (Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
        System.exit(0);
    }
    return result;
}}

