public class Dummy{
public static boolean item_nameSearch(String item_name) {
    boolean result = false;
    try {
        c = ShopNow.openDB();
        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM ITEM WHERE ITEM_NAME LIKE '" + item_name + "';");
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

