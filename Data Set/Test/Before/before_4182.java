class Dummy{
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    int id = Integer.parseInt(fid.getText());
    String name = fname.getText();
    String source = (String) scb.getSelectedItem();
    String destination = (String) dcb.getSelectedItem();
    String HD = hd.getText();
    String MD = md.getText();
    String HA = ha.getText();
    String MA = ma.getText();
    String departure = HD + " : " + MD;
    String arrival = HA + " : " + MA;
    int charges = Integer.parseInt(chargesf.getText());
    String date = datef.getText();
    try {
        Class.forName("java.sql.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/airline_reservation?verifyServerCertificate=false&useSSL=true", "root", "pragun");
        stmt = con.createStatement();
        String query = "Insert into flights values(" + id + ",'" + name + "','" + source + "','" + destination + "','" + departure + "','" + arrival + "'," + charges + ",'" + date + "');";
        stmt.executeUpdate(query);
        JOptionPane.showMessageDialog(null, "Flight added successfully");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Flight couldn't be added");
    }
}}

