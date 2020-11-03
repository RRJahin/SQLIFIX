class Dummy{
public void actionPerformed(ActionEvent e) {
    if (connect == null) {
        JOptionPane.showMessageDialog(null, "NOT YET CONNECTED");
    } else {
        try {
            Statement st45 = OracleDatabaseConnection.connect.createStatement();
            String query = "select * from passwordsr where username='" + _username_textfield.getText() + "'";
            ResultSet rs12 = st45.executeQuery(query);
            while (rs12.next()) {
                _password_textfield.setText(rs12.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserCreation.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Statement stmt2;
            String queryCheck = "SELECT * from usersr WHERE username ='" + _username_textfield.getText() + "' and password='" + _password_textfield.getText() + "'";
            stmt2 = connector.createStatement();
            ResultSet rs91 = stmt2.executeQuery(queryCheck);
            int variables = 0;
            final ResultSetMetaData metaData = rs91.getMetaData();
            if (rs91.next()) {
                tableeasy.MainActivity.usernames = Integer.parseInt(rs91.getString(metaData.getColumnName(2)));
                variables++;
            }
            System.out.println(tableeasy.MainActivity.usernames);
            if (variables != 0) {
                System.out.println("LOGIN");
                dispose();
                JOptionPane.showMessageDialog(null, "Logged in as " + _username_textfield.getText());
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect username and password");
            }
            System.out.println("here:  " + tableeasy.MainActivity.usernames);
            if (tableeasy.MainActivity.usernames == 1) {
                tableeasy.graphicaluserinterface.widgets.MainTabbedPane._create_database.setVisible(true);
                tableeasy.graphicaluserinterface.widgets.MainTabbedPane._create_database.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (tableeasy.MainActivity.usernames == 0) {
                            JOptionPane.showMessageDialog(null, "NO USER SO FAR");
                        } else {
                            System.out.println(tableeasy.MainActivity.usernames);
                            if (connect == null) {
                                JOptionPane.showMessageDialog(null, "NOT YET CONNECTED");
                            } else {
                                Databases d = new Databases();
                                d.setLocationRelativeTo(null);
                                d.setVisible(true);
                            }
                        }
                    }
                });
            } else {
                tableeasy.graphicaluserinterface.widgets.MainTabbedPane._create_database.setVisible(false);
            }
            Statement stmt = connector.createStatement();
            String squery = "select * from databaser where userid=" + tableeasy.MainActivity.usernames;
            ResultSet rs = stmt.executeQuery(squery);
            ResultSetMetaData metaData123 = rs.getMetaData();
            int i = 0;
            while (rs.next()) {
                MainTabbedPane.smine[i] = rs.getString(metaData123.getColumnName(1));
                tableeasy.MainActivity.databases[i + 1] = rs.getString(1);
                System.out.println("dfsdfsdfsd::" + tableeasy.MainActivity.databases[i + 1]);
                i++;
            }
            MainTabbedPane.databases.setModel(new javax.swing.DefaultComboBoxModel(smine));
            tableeasy.MainActivity.noofdata = i;
        } catch (SQLException ex) {
            Logger.getLogger(UserCreation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}}

