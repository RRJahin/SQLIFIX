public class Dummy{
public static boolean delete(String item_name) {
    boolean result = false;
    try {
        c = ShopNow.openDB();
        stmt = c.createStatement();
        String sql = "DELETE from ITEM where ITEM_NAME LIKE '" + item_name + "';";
        stmt.executeUpdate(sql);
        stmt.close();
        ShopNow.closeDB();
    } catch (Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
        System.exit(0);
    }
    return result;
}}

