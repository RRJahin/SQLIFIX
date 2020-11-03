public class Dummy{
public static String[] viewItem(String input) {
    String[] array = new String[6];
    try {
        c = ShopNow.openDB();
        stmt = c.prepareStatement("SELECT * FROM ITEM WHERE ITEM_NAME LIKE ?;");
        stmt.setObject(1,input);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            int item_id = rs.getInt("item_id");
            String item_name = rs.getString("item_name");
            String department = rs.getString("department");
            String description = rs.getString("description");
            String image = rs.getString("image");
            Double price = rs.getDouble("price");
            int quantity = rs.getInt("quantity");
            System.out.println("ITEM_ID = " + item_id);
            System.out.println("ITEM_NAME = " + item_name);
            array[0] = item_name;
            System.out.println("DESCRIPTION = " + description);
            array[5] = description;
            System.out.println("IMAGE = " + image);
            array[4] = image;
            System.out.println("QUANTITY = " + quantity);
            array[1] = Integer.toString(quantity);
            System.out.println("PRICE = " + price);
            array[2] = Double.toString(price);
            System.out.println("DEPARTMENT = " + department);
            array[3] = department;
            System.out.println();
        }
        rs.close();
        stmt.close();
        ShopNow.closeDB();
    } catch (Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
        System.exit(0);
    }
    return array;
}}

