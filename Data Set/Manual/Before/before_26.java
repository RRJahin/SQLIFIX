public class Dummy{
public static boolean delete(String email) {
    boolean result = false;
    try {
        c = ShopNow.openDB();
        stmt = c.createStatement();
        String sql = "DELETE from ADMIN where EMAIL LIKE '" + email + "';";
        stmt.executeUpdate(sql);
        stmt.close();
        ShopNow.closeDB();
    } catch (Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
        System.exit(0);
    }
    return result;
}}

