class Dummy{
private void upActionPerformed(java.awt.event.ActionEvent evt) {
    int ans = JOptionPane.showConfirmDialog(null, "Surely wanna update the record?");
    if (ans == JOptionPane.YES_OPTION) {
        try {
            stmt = con.createStatement();
            int id = Integer.parseInt(fid.getText());
            String name = fname.getText();
            String dest = fdest.getText();
            String source = fsource.getText();
            String dep = fdep.getText();
            String arrival = farrival.getText();
            int charges = Integer.parseInt(fcharges.getText());
            String date = fdate.getText();
            String query = "Update flights SET Name = '" + name + "', Source = '" + source + "', Destination = '" + dest + "', Departure = '" + dep + "', Arrival = '" + arrival + "', Date = '" + date + "', Charges = '" + charges + "' Where ID = " + id + ";";
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Record Updated Succesfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in table Updation");
        }
    }
}}

