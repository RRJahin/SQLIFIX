class Dummy{
public void valueSetter(int uid) {
    OracleDatabaseConnection conn = new OracleDatabaseConnection();
    Connection connector = conn.checkLogin(conn.hostn, conn.portn, conn.databasen, conn.usern, conn.passn);
    if (connector == null) {
        JOptionPane.showMessageDialog(null, "NOT CONNECTED");
    } else {
        try {
            Statement stmt = connector.createStatement();
            String s2 = "select * from usersr where userid=" + MainActivity.usernames;
            ResultSet rs12 = stmt.executeQuery(s2);
            while (rs12.next()) {
                jLabel2.setText(rs12.getString("username"));
            }
            String s = "select * from databaser where userid=" + MainActivity.usernames;
            System.out.println(s);
            int i = 1;
            String[] dbnames = new String[100];
stmt = connector.createStatement();
            ResultSet rs13 = stmt.executeQuery(s);
            ResultSetMetaData metaData = rs13.getMetaData();
            while (rs13.next()) {
                System.out.println(rs13.getString("dbname"));
                dbnames[i] = rs13.getString("dbname");
                i++;
            }
            jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { dbnames[1] }));
            for (int k = 2; k < i; k++) {
                jComboBox1.addItem(dbnames[k]);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Table.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}}

