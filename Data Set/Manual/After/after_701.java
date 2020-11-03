public class Dummy{
public static String[] edit(String EMAIL, String FIRST_NAME, String LAST_NAME, String PHONE) {
    String[] array = new String[6];
    try {
        c = ShopNow.openDB();
        stmt = c.createStatement();
        String sql = ("UPDATE ADMIN set EMAIL = '" + EMAIL + "' where EMAIL LIKE '" + EMAIL + "';");
        stmt.executeUpdate(sql);
        stmt.close();
        ShopNow.closeDB();
        array[1] = EMAIL;
        c = ShopNow.openDB();
        stmt = c.createStatement();
        sql = ("UPDATE ADMIN set FIRST_NAME = '" + FIRST_NAME + "' where EMAIL LIKE '" + EMAIL + "';");
        stmt.executeUpdate(sql);
        stmt.close();
        ShopNow.closeDB();
        array[2] = FIRST_NAME;
        c = ShopNow.openDB();
        stmt = c.createStatement();
        sql = ("UPDATE ADMIN set LAST_NAME = '" + LAST_NAME + "' where EMAIL LIKE '" + EMAIL + "';");
        stmt.executeUpdate(sql);
        stmt.close();
        ShopNow.closeDB();
        array[3] = LAST_NAME;
        c = ShopNow.openDB();
        stmt = c.createStatement();
        sql = ("UPDATE ADMIN set PHONE = '" + PHONE + "' where EMAIL LIKE '" + EMAIL + "';");
        stmt.executeUpdate(sql);
        stmt.close();
        ShopNow.closeDB();
        array[4] = PHONE;
    } catch (Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
        System.exit(0);
    }
    return array;
}}

