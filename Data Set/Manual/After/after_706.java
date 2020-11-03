public class Dummy{
public static boolean delete(String item_name) {
    boolean result = false;
    try {
        c = ShopNow.openDB();
        String sql = "DELETE from ITEM where ITEM_NAME LIKE ?;";
        stmt = c.prepareStatement(sql);
        stmt.setObject(1,item_name);
        stmt.executeUpdate();
        stmt.close();
        ShopNow.closeDB();
    } catch (Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
        System.exit(0);
    }
    return result;
}}

