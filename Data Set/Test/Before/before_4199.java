class Dummy{
public static String modifyProducts(HttpServletRequest request) {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    try {
        try {
            conn = HelperUtils.connect();
        } catch (Exception e) {
            return HelperUtils.printError("Internal Server Error. This shouldn't happen.");
        }
        stmt = conn.createStatement();
        String action = null, id_str = null;
        String name = "", cname = "", sku = "", price = "", cid = "";
        try {
            action = request.getParameter("action");
        } catch (Exception e) {
            return "";
        }
        try {
            id_str = request.getParameter("id");
        } catch (Exception e) {
            id_str = null;
        }
        try {
            name = request.getParameter("name");
            cname = request.getParameter("cname");
            sku = request.getParameter("sku");
            price = request.getParameter("price");
            if (cname != null) {
                String query = "SELECT id FROM categories WHERE name='" + cname + "'";
                rs = stmt.executeQuery(query);
                if (rs.next()) {
                    cid = rs.getString(1);
                } else {
                    return HelperUtils.printError("Category chosen does not exist!");
                }
            }
        } catch (Exception e) {
            name = null;
            cname = null;
            sku = null;
            price = null;
            cid = null;
        }
        if (("insert").equals(action)) {
            String SQL_1 = "INSERT INTO products (cid, name, SKU, price) VALUES(" + cid + ",'" + name + "','" + sku + "', " + price + ");";
            try {
                conn.setAutoCommit(false);
                stmt.execute(SQL_1);
                conn.commit();
stmt = conn.createStatement();
                conn.setAutoCommit(true);
                return HelperUtils.printSuccess("Insertion successful");
            } catch (Exception e) {
                return HelperUtils.printError("Insert failed! Please <a href=\"products\" target=\"_self\">insert it</a> again.<br/>" + e.getLocalizedMessage());
            }
        } else if (("update").equals(action)) {
            String SQL_2 = "update products set name='" + name + "' , SKU='" + sku + "'  , price='" + price + "' where id=" + id_str + ";";
            try {
                conn.setAutoCommit(false);
                stmt.execute(SQL_2);
stmt = conn.createStatement();
                conn.commit();
                conn.setAutoCommit(true);
                return HelperUtils.printSuccess("Update successful.");
            } catch (Exception e) {
                return HelperUtils.printError("Updated Failed! Please <a href=\"products\" target=\"_self\">Update it</a> again.<br/>" + e.getLocalizedMessage());
            }
        } else if (("delete").equals(action)) {
            String SQL_3 = "delete from products where id=" + id_str + ";";
            try {
                conn.setAutoCommit(false);
stmt = conn.createStatement();
                stmt.execute(SQL_3);
                conn.commit();
                conn.setAutoCommit(true);
                return HelperUtils.printSuccess("Deletion successful.");
            } catch (Exception e) {
                return HelperUtils.printError("Deletion Failed! Please try again in the <a href=\"products\" target=\"_self\">products page</a>.<br><br>");
            }
        } else {
            return "";
        }
    } catch (Exception e) {
        return HelperUtils.printError("Some error happened!<br/>" + e.getLocalizedMessage());
    } finally {
        try {
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}}

