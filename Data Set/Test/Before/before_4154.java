class Dummy{
private void totalActionPerformed(java.awt.event.ActionEvent evt) {
    Connection con = null;
    try {
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        con = DriverManager.getConnection(url, user, pass);
        String sql = "SELECT total from adds where cart_id = " + cid;
        int total = 0;
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            int i = rs.getInt("total");
            total = total + i;
        }
        String infoMessage = "Total = " + total;
        JOptionPane.showMessageDialog(null, infoMessage, "Discount ", JOptionPane.INFORMATION_MESSAGE);
        con.close();
    } catch (Exception ex) {
        System.err.println(ex);
    }
}}

