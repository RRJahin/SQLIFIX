public class Dummy{
private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
    Statement stmt;
    try {
        stmt = OracleDatabaseConnection.connect.createStatement();
        name = _table_name.getText();
        String squery1 = "select * from tablesr where dbname='" + tableeasy.MainActivity.databases[tableeasy.MainActivity.selecteddata] + "'";
        ResultSet rs = stmt.executeQuery(squery1);
        ResultSetMetaData metaData1 = rs.getMetaData();
        int fl = 0;
        int counter = 1;
        while (rs.next()) {
            if (_table_name.getText().equals(rs.getString(metaData1.getColumnName(1))))
                fl = 1;
            counter++;
        }
        _table_name.getText();
        if (fl == 0) {
            JOptionPane.showMessageDialog(null, "NO SUCH TABLE");
        } else {
            Addcoloumn ac = new Addcoloumn();
            ac.setVisible(true);
            ac.setLocationRelativeTo(null);
        }
    } catch (SQLException ex) {
        Logger.getLogger(OtherQueries.class.getName()).log(Level.SEVERE, null, ex);
    }
}}

