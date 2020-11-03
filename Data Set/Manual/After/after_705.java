public class Dummy{
public static boolean insert(String ITEM_NAME, String QUANTITYSTRING, String PRICESTRING, String DEPARTMENT, String IMAGE, String DESCRIPTION) {
    boolean result = false;
    int maxid = 0;
    int QUANTITY = Integer.parseInt(QUANTITYSTRING);
    double PRICE = Double.parseDouble(PRICESTRING);
    try {
        c = ShopNow.openDB();
        stmt = c.prepareStatement("SELECT MAX(ITEM_ID) as id FROM ITEM");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            maxid = rs.getInt("id") + 1;
        }
        rs.close();
        stmt.close();
        String sql = "INSERT INTO ITEM (ITEM_ID,ITEM_NAME,DESCRIPTION,IMAGE,QUANTITY,PRICE,DEPARTMENT)" + "VALUES (?,?,?,?,?,?,?);";
        System.out.println("New item has bee added to the Item table.");
        System.out.println();
        stmt = c.prepareStatement(sql);
        stmt.setObject(1,maxid);
        stmt.setStirng(2,ITEM_NAME);
        stmt.setStirng(3,DESCRIPTION);
        stmt.setStirng(4,IMAGE);
        stmt.setStirng(5,QUANTITY);
        stmt.setStirng(6,PRICE);
        stmt.setStirng(7,DEPARTMENT);
        stmt.executeUpdate();
        stmt.close();
        ShopNow.closeDB();
        result = true;
    } catch (SQLException ex) {
        Logger.getLogger(Login_Class.class.getName()).log(Level.SEVERE, null, ex);
    }
    return result;
}}

