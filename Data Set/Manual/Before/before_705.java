public class Dummy{
public static boolean insert(String ITEM_NAME, String QUANTITYSTRING, String PRICESTRING, String DEPARTMENT, String IMAGE, String DESCRIPTION) {
    boolean result = false;
    int maxid = 0;
    int QUANTITY = Integer.parseInt(QUANTITYSTRING);
    double PRICE = Double.parseDouble(PRICESTRING);
    try {
        c = ShopNow.openDB();
        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT MAX(ITEM_ID) as id FROM ITEM");
        while (rs.next()) {
            maxid = rs.getInt("id") + 1;
        }
        rs.close();
        stmt.close();
        String sql = "INSERT INTO ITEM (ITEM_ID,ITEM_NAME,DESCRIPTION,IMAGE,QUANTITY,PRICE,DEPARTMENT)" + "VALUES (" + maxid + ", '" + ITEM_NAME + "','" + DESCRIPTION + "','" + IMAGE + "'," + QUANTITY + "," + PRICE + ",'" + DEPARTMENT + "');";
        System.out.println("New item has bee added to the Item table.");
        System.out.println();
        stmt.executeUpdate(sql);
        stmt.close();
        ShopNow.closeDB();
        result = true;
    } catch (SQLException ex) {
        Logger.getLogger(Login_Class.class.getName()).log(Level.SEVERE, null, ex);
    }
    return result;
}}

