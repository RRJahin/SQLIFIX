class Dummy{
private void addActionPerformed(java.awt.event.ActionEvent evt) {
    Connection con = null;
    try {
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        con = DriverManager.getConnection(url, user, pass);
        String sql = "SELECT item_code from items where name ='" + list.getSelectedItem() + "'";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        rs.next();
        int id = rs.getInt("item_code");
        int price = Integer.parseInt(prce.getText());
        sql = "insert into produces values(" + id + "," + vid + "," + price + ")";
st = con.createStatement();
        int m = st.executeUpdate(sql);
        if (m == 1) {
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Item listed");
        } else {
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Please try again");
        }
        con.close();
    } catch (Exception ex) {
        System.err.println(ex);
    }
}}

