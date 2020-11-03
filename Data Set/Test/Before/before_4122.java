class Dummy{
private void ChngAvaiActionPerformed(java.awt.event.ActionEvent evt) {
    Connection con = null;
    try {
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        con = DriverManager.getConnection(url, user, pass);
        String sql = "SELECT item_code from items where name ='" + list2.getSelectedItem() + "'";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        rs.next();
        int id = rs.getInt("item_code");
        sql = "update sale set availabity ='" + availability.getText() + "' where item_code =" + id;
        st = con.createStatement();
        int m = st.executeUpdate(sql);
        if (m == 1) {
            JFrame frame1 = new JFrame();
            JOptionPane.showMessageDialog(frame1, "Updated");
        } else {
            JFrame frame1 = new JFrame();
            JOptionPane.showMessageDialog(frame1, "Please try again");
        }
        con.close();
    } catch (Exception ex) {
        System.err.println(ex);
    }
}}

