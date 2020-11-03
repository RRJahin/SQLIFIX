public class Dummy{
public static boolean delete(String email) {
    boolean result = false;
    try {
        c = ShopNow.openDB();
        String sql = "DELETE from ADMIN where EMAIL LIKE ?;";
        stmt = c.prepareStatement(sql);
        stmt.setObject(1,email);
        stmt.executeUpdate();
        stmt.close();
        ShopNow.closeDB();
    } catch (Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
        System.exit(0);
    }
    return result;
}}

