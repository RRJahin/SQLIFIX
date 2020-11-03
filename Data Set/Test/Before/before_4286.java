class Dummy{
private void list_nameActionPerformed(java.awt.event.ActionEvent evt) {
    Connection con = null;
    try {
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        con = DriverManager.getConnection(url, user, pass);
        String sql = "SELECT item_code from items where name ='" + list_name.getSelectedItem() + "'";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        list_price.removeAll();
        int id;
        rs.next();
        id = rs.getInt("item_code");
        sql = "select id,price from produces where item_code = " + id;
        st = con.createStatement();
        rs = st.executeQuery(sql);
        while (rs.next()) {
            int vendor = rs.getInt("id");
            int price = rs.getInt("price");
            String sql1 = "select name from vendor where id = " + vendor;
            Statement st1 = con.createStatement();
            ResultSet r = st1.executeQuery(sql1);
            r.next();
            String v = r.getString("name");
            list_price.add(v + " " + price);
        }
        con.close();
    } catch (Exception ex) {
        System.err.println(ex);
    }
}}

