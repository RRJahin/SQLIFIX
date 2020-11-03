public class Dummy{
public static String[] edit(String ITEM_NAME, String QUANTITYSTRING, String PRICESTRING, String DEPARTMENT, String IMAGE, String DESCRIPTION) {
    int QUANTITY = Integer.parseInt(QUANTITYSTRING);
    double PRICE = Double.parseDouble(PRICESTRING);
    String[] array = new String[6];
    try {
        c = ShopNow.openDB();
        stmt = c.createStatement();
        String sql = ("UPDATE ITEM set PRICE = '" + PRICE + "' where ITEM_NAME LIKE '" + ITEM_NAME + "';");
        stmt.executeUpdate(sql);
        stmt.close();
        ShopNow.closeDB();
        array[2] = Double.toString(PRICE);
        c = ShopNow.openDB();
        stmt = c.createStatement();
        sql = ("UPDATE ITEM set DEPARTMENT = '" + DEPARTMENT + "' where ITEM_NAME LIKE '" + ITEM_NAME + "';");
        stmt.executeUpdate(sql);
        stmt.close();
        ShopNow.closeDB();
        array[3] = DEPARTMENT;
        c = ShopNow.openDB();
        stmt = c.createStatement();
        sql = ("UPDATE ITEM set DESCRIPTION = '" + DESCRIPTION + "' where ITEM_NAME LIKE '" + ITEM_NAME + "';");
        stmt.executeUpdate(sql);
        stmt.close();
        ShopNow.closeDB();
        array[5] = DESCRIPTION;
        c = ShopNow.openDB();
        stmt = c.createStatement();
        sql = ("UPDATE ITEM set IMAGE = '" + IMAGE + "' where ITEM_NAME LIKE '" + ITEM_NAME + "';");
        stmt.executeUpdate(sql);
        stmt.close();
        ShopNow.closeDB();
        array[4] = IMAGE;
        c = ShopNow.openDB();
        stmt = c.createStatement();
        sql = ("UPDATE ITEM set QUANTITY = '" + QUANTITY + "' where ITEM_NAME LIKE '" + ITEM_NAME + "';");
        stmt.executeUpdate(sql);
        stmt.close();
        ShopNow.closeDB();
        array[1] = Integer.toString(QUANTITY);
        c = ShopNow.openDB();
        stmt = c.createStatement();
        sql = ("UPDATE ITEM set ITEM_NAME = '" + ITEM_NAME + "' where ITEM_NAME LIKE '" + ITEM_NAME + "';");
        stmt.executeUpdate(sql);
        stmt.close();
        ShopNow.closeDB();
        array[0] = ITEM_NAME;
    } catch (Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
        System.exit(0);
    }
    return array;
}}

