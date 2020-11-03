class Dummy{
private void upActionPerformed(java.awt.event.ActionEvent evt) {
    int ans = JOptionPane.showConfirmDialog(null, "Surely wanna update the record?");
    if (ans == JOptionPane.YES_OPTION) {
        try {
            stmt = con.createStatement();
            int id = Integer.parseInt(id1.getText());
            String name = name1.getText();
            String gender = null;
            if (male1.isSelected())
                gender = "male";
            else if (female1.isSelected())
                gender = "female";
            String dob = dob1.getText();
            String address = add1.getText();
            String query = "Update customers SET Name = '" + name + "', DOB = '" + dob + "', Gender = '" + gender + "', Address = '" + address + "' WHERE ID = " + id + " ;";
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Record Updated Succesfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in table Updation");
        }
    }
}}

