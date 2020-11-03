public class Dummy{
public static boolean emailSearch(String email) {
    boolean result = false;
    try {
        c = ShopNow.openDB();
        stmt = c.prepareStatement("SELECT * FROM ADMIN WHERE EMAIL LIKE ?;");
        stmt.setObject(1,email);
        ResultSet rs = stmt.executeQuery();
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

