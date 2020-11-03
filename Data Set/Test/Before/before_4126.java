class Dummy{
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    DefaultTableModel model = (DefaultTableModel) cust.getModel();
    try {
        Class.forName("java.sql.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/airline_reservation?verifyServerCertificate=false&useSSL=true", "root", "pragun");
        stmt = con.createStatement();
        String query = "Select * from customers Where ID =" + id1.getText() + ";";
        rs = stmt.executeQuery(query);
        if (rs.next()) {
            String name = rs.getString("Name");
            String dob = rs.getString("DOB");
            String gender = rs.getString("Gender");
            String address = rs.getString("Address");
            String idx = rs.getString("ID");
            model.addRow(new Object[] { idx, name, gender, dob, address });
            name1.setText(name);
            dob1.setText(dob);
            add1.setText(address);
            if (gender.equals("male"))
                male1.setSelected(true);
            else if (gender.equals("female"))
                female1.setSelected(true);
        } else {
            JOptionPane.showMessageDialog(null, "No such record found");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error in Connectivity");
    }
    del.setEnabled(true);
    up.setEnabled(true);
}}

