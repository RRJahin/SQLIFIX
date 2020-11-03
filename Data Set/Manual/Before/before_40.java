public class Dummy{
private void ship_signupActionPerformed(java.awt.event.ActionEvent evt) {
    Connection con = null;
    try {
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        con = DriverManager.getConnection(url, user, pass);
        String sql = "SELECT MAX(ship_id) from shipping";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        rs.next();
        int id = rs.getInt("MAX(ship_id)");
        id = id + 1;
        String n = Name.getText();
        sql = "insert into shipping values(" + id + ",'" + n + "')";
        int m = st.executeUpdate(sql);
        if (m == 1) {
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Shipping Id is " + Integer.toString(id));
        }
        con.close();
    } catch (Exception ex) {
        System.err.println(ex);
    }
}}

