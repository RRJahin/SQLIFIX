class Dummy{
private void delActionPerformed(java.awt.event.ActionEvent evt) {
    int ans = JOptionPane.showConfirmDialog(null, "Surely wanna delete the record?");
    if (ans == JOptionPane.YES_OPTION) {
        try {
            stmt = con.createStatement();
            int id = Integer.parseInt(id1.getText());
            String query = "Delete From customers Where ID = " + id + ";";
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Record Deleted Succesfully");
            id1.setText("");
            name1.setText("");
            add1.setText("");
            dob1.setText("");
            buttonGroup1.clearSelection();
            del.setEnabled(false);
            up.setEnabled(false);
            DefaultTableModel model = (DefaultTableModel) cust.getModel();
            model.setRowCount(0);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in Deletion");
        }
    }
}}

