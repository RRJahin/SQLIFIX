class Dummy{
private void add_newActionPerformed(java.awt.event.ActionEvent evt) {
    Connection con = null;
    try {
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        con = DriverManager.getConnection(url, user, pass);
        String sql = "SELECT MAX(item_code) from items";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        rs.next();
        int id = rs.getInt("MAX(item_code)");
        id = id + 1;
        String name = i_name.getText();
        String p = i_price.getText();
        int price = Integer.parseInt(p);
        String type = i_type.getText();
        CallableStatement cStmt = con.prepareCall("{call list_items(?,?,?,?,?)}");
        cStmt.setInt(1, vid);
        cStmt.setInt(2, id);
        cStmt.setString(3, name);
        cStmt.setString(4, type);
        cStmt.setInt(5, price);
cStmt = con.createStatement();
        cStmt.execute();
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, "Inserted into items");
        con.close();
    } catch (Exception ex) {
        System.err.println(ex);
    }
}}

