class Dummy{
private void removeActionPerformed(java.awt.event.ActionEvent evt) {
    Connection con = null;
    try {
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        String select = cart.getSelectedItem();
        String[] x = select.split(" ");
        String n = x[0];
        con = DriverManager.getConnection(url, user, pass);
        String sql = "SELECT item_code from items where name = '" + n + "'";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        rs.next();
        int item = rs.getInt("item_code");
        sql = "delete from adds where cart_id = " + cid + "and item_code = " + item;
st = con.createStatement();
        int m = st.executeUpdate(sql);
        if (m == 1) {
            sql = "SELECT item_code,price,quantity from adds where cart_id = " + cid;
            cart.removeAll();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                int i = rs.getInt("item_code");
                int p = rs.getInt("price");
                int q = rs.getInt("quantity");
                String sql1 = "select name from items where item_code = " + i;
                Statement st1 = con.createStatement();
                ResultSet r = st1.executeQuery(sql1);
                r.next();
                String name = r.getString("name");
                cart.add(name + " " + p + " " + q);
            }
        }
        con.close();
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}}

