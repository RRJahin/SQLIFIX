class Dummy{
private void delActionPerformed(java.awt.event.ActionEvent evt) {
    int ans = JOptionPane.showConfirmDialog(null, "Surely wanna delete the record?");
    if (ans == JOptionPane.YES_OPTION) {
        try {
            stmt = con.createStatement();
            int id = Integer.parseInt(fid.getText());
            String query = "Delete From flights Where ID = " + id + ";";
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Record Deleted Succesfully");
            fid.setText("");
            fname.setText("");
            fsource.setText("");
            fdest.setText("");
            farrival.setText("");
            fdep.setText("");
            fdate.setText("");
            fcharges.setText("");
            DefaultTableModel model = (DefaultTableModel) flightt.getModel();
            model.setRowCount(0);
            del.setEnabled(false);
            up.setEnabled(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in Deletion");
        }
    }
}}

