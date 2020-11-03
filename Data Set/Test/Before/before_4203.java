class Dummy{
public static String purchaseCart(ShoppingCart cart, Integer uid) {
    Connection conn = null;
    Statement stmt = null;
    try {
        try {
            conn = HelperUtils.connect();
        } catch (Exception e) {
            return HelperUtils.printError("Internal Server Error. This shouldn't happen.");
        }
        stmt = conn.createStatement();
        for (int i = 0; i < cart.getProducts().size(); i++) {
            ProductWithCategoryName p = cart.getProducts().get(i);
            int quantity = cart.getQuantities().get(i);
            conn.setAutoCommit(false);
            String SQL_1 = "INSERT INTO cart_history (uid) VALUES (" + uid + ");";
            stmt.execute(SQL_1);
            String SQL_2 = "SELECT lastval();";
stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL_2);
            rs.next();
            int cart_id = rs.getInt(1);
            String SQL_3 = "INSERT INTO sales (uid, pid, cart_id, quantity, price) VALUES(" + uid + ",'" + p.getId() + "','" + cart_id + "','" + quantity + "', " + p.getPrice() + ");";
stmt = conn.createStatement();
            stmt.execute(SQL_3);
            conn.commit();
            conn.setAutoCommit(true);
        }
        cart.empty();
        return HelperUtils.printSuccess("Purchase successful!");
    } catch (SQLException e) {
        return HelperUtils.printError("Oops! Looks like the product you want to buy is no longer available...");
    } finally {
        try {
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}}

