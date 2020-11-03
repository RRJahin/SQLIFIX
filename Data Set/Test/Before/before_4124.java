class Dummy{
private void view_discountActionPerformed(java.awt.event.ActionEvent evt) {
    Connection con = null;
    try {
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        con = DriverManager.getConnection(url, user, pass);
        String sql = "SELECT item_code from items where name ='" + list2.getSelectedItem() + "'";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        rs.next();
        int id = rs.getInt("item_code");
        sql = "SELECT discount,availabity from sale where item_code =" + id;
        st = con.createStatement();
        rs = st.executeQuery(sql);
        discount.setText("");
        availability.setText("");
        while (rs.next()) {
            int d = rs.getInt("discount");
            String avail = rs.getString("availabity");
            discount.setText(Integer.toString(d));
            availability.setText(avail);
        }
        con.close();
    } catch (Exception ex) {
        System.err.println(ex);
    }
}}

