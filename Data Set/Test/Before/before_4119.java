class Dummy{
private void selectActionPerformed(java.awt.event.ActionEvent evt) {
    Connection con = null;
    try {
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        con = DriverManager.getConnection(url, user, pass);
        String sql = "SELECT i.item_code,i.name,i.type,p.price from items i,produces p where i.name ='" + list1.getSelectedItem() + "' and i.item_code = p.item_code";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        iname.setText("");
        itype.setText("");
        iprice.setText("");
        while (rs.next()) {
            int id = rs.getInt("item_code");
            String name = rs.getString("name");
            String type = rs.getString("type");
            int price = rs.getInt("price");
            iname.setText(name);
            itype.setText(type);
            iprice.setText(Integer.toString(price));
        }
        con.close();
    } catch (Exception ex) {
        System.err.println(ex);
    }
}}

