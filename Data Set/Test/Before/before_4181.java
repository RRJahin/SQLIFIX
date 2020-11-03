class Dummy{
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    int ID = Integer.parseInt(id.getText());
    String Name = name.getText();
    String DOB = dob.getText();
    String Gender = null;
    if (male1.isSelected())
        Gender = "male";
    else if (female1.isSelected())
        Gender = "female";
    String Address = address.getText();
    try {
        Class.forName("java.sql.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/airline_reservation?verifyServerCertificate=false&useSSL=true", "root", "pragun");
        stmt = con.createStatement();
        String query = "Insert into customers values(" + ID + ",'" + Name + "','" + Gender + "','" + DOB + "','" + Address + "');";
        stmt.executeUpdate(query);
        JOptionPane.showMessageDialog(null, "Record Saved Succesfully");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Record could not be saved");
    }
}}

