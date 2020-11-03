class Dummy{
private void orderActionPerformed(java.awt.event.ActionEvent evt) {
    String card = JOptionPane.showInputDialog("Please insert credit card number ");
    long cardno = Long.parseLong(card);
    String pin = JOptionPane.showInputDialog("Please insert credit card pin ");
    int pinnum = Integer.parseInt(pin);
    Connection con = null;
    try {
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        con = DriverManager.getConnection(url, user, pass);
        int cusid = cid - 400;
        String sql = "SELECT card_no from credit_card where c_id = " + cusid;
        int flag = 0;
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            long i = rs.getInt("card_no");
            if (i == cardno)
                flag = 1;
        }
        if (flag == 1) {
            sql = "select max(order_id) from myorder";
st = con.createStatement();
            rs = st.executeQuery(sql);
st = con.createStatement();
            rs.next();
            int oid = rs.getInt("max(order_id)");
            oid = oid + 1;
            sql = "insert into myorder values(" + oid + "," + cid + ")";
            int m = st.executeUpdate(sql);
st = con.createStatement();
            if (m == 1) {
                JFrame frame1 = new JFrame();
                JOptionPane.showMessageDialog(frame1, "Placed Order");
            }
        } else {
            CallableStatement cStmt = con.prepareCall("{call add_card(?,?,?,?)}");
            cStmt.setLong(1, cardno);
            cStmt.setInt(2, pinnum);
            cStmt.setInt(3, cusid);
            cStmt.setInt(4, cid);
cStmt = con.createStatement();
            cStmt.execute();
            JFrame frame1 = new JFrame();
            JOptionPane.showMessageDialog(frame1, "Placed Order");
        }
        con.close();
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}}

