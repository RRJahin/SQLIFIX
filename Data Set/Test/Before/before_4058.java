class Dummy{
private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
    jLabel3.setVisible(false);
    jLabel4.setVisible(false);
    jLabel5.setVisible(false);
    jLabel7.setVisible(false);
    jLabel8.setVisible(false);
    jLabel6.setVisible(false);
    jLabel9.setVisible(false);
    jLabel10.setVisible(false);
    jLabel11.setVisible(false);
    jLabel12.setVisible(false);
    jLabel13.setVisible(false);
    jLabel14.setVisible(false);
    jLabel15.setVisible(false);
    jLabel16.setVisible(false);
    jLabel17.setVisible(false);
    jLabel19.setVisible(false);
    jLabel18.setVisible(false);
    jLabel20.setVisible(false);
    jLabel21.setVisible(false);
    jLabel22.setVisible(false);
    jLabel23.setVisible(false);
    String s = jComboBox1.getSelectedItem().toString();
    String sq = "select * from tablesr where dbname='" + s + "'";
    try {
        Statement st = OracleDatabaseConnection.connect.createStatement();
        ResultSet rs = st.executeQuery(sq);
        int i = 1;
        String[] t = new String[100];
        while (rs.next()) {
            t[i] = rs.getString("tablename");
            if (i == 1) {
                jLabel3.setVisible(true);
                jLabel3.setText(t[i]);
            }
            if (i == 2) {
                jLabel4.setVisible(true);
                jLabel4.setText(t[i]);
            }
            if (i == 3) {
                jLabel5.setVisible(true);
                jLabel5.setText(t[i]);
            }
            if (i == 4) {
                jLabel6.setVisible(true);
                jLabel6.setText(t[i]);
            }
            if (i == 5) {
                jLabel7.setVisible(true);
                jLabel7.setText(t[i]);
            }
            if (i == 6) {
                jLabel8.setVisible(true);
                jLabel8.setText(t[i]);
            }
            if (i == 7) {
                jLabel9.setVisible(true);
                jLabel9.setText(t[i]);
            }
            if (i == 8) {
                jLabel10.setVisible(true);
                jLabel10.setText(t[i]);
            }
            if (i == 9) {
                jLabel11.setVisible(true);
                jLabel11.setText(t[i]);
            }
            if (i == 10) {
                jLabel12.setVisible(true);
                jLabel12.setText(t[i]);
            }
            if (i == 11) {
                jLabel13.setVisible(true);
                jLabel13.setText(t[i]);
            }
            if (i == 12) {
                jLabel14.setVisible(true);
                jLabel14.setText(t[i]);
            }
            if (i == 13) {
                jLabel15.setVisible(true);
                jLabel15.setText(t[i]);
            }
            if (i == 14) {
                jLabel16.setVisible(true);
                jLabel16.setText(t[i]);
            }
            if (i == 15) {
                jLabel17.setVisible(true);
                jLabel17.setText(t[i]);
            }
            if (i == 16) {
                jLabel18.setVisible(true);
                jLabel18.setText(t[i]);
            }
            if (i == 17) {
                jLabel19.setVisible(true);
                jLabel19.setText(t[i]);
            }
            if (i == 18) {
                jLabel20.setVisible(true);
                jLabel20.setText(t[i]);
            }
            if (i == 19) {
                jLabel21.setVisible(true);
                jLabel21.setText(t[i]);
            }
            if (i == 20) {
                jLabel22.setVisible(true);
                jLabel22.setText(t[i]);
            }
            if (i == 21) {
                jLabel23.setVisible(true);
                jLabel23.setText(t[i]);
            }
            i++;
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "NO CONNECTION");
        Logger.getLogger(Table.class.getName()).log(Level.SEVERE, null, ex);
    }
}}

