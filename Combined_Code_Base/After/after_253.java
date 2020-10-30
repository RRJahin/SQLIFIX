public class Dummy{
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    try {
        PreparedStatement stmt;
        OracleDatabaseConnection conn = new OracleDatabaseConnection();
        Connection connector = conn.checkLogin(conn.hostn, conn.portn, conn.databasen, conn.usern, conn.passn);
        String squery = "select * from tablesr where dbname='?'";
        System.out.println(tableeasy.MainActivity.databases[tableeasy.MainActivity.selecteddata]);
        stmt = connector.prepareStatement(squery);
        stmt.setObject(1,tableeasy.MainActivity.databases[tableeasy.MainActivity.selecteddata]);
        ResultSet rs = stmt.executeQuery();
        ResultSetMetaData metaData1 = rs.getMetaData();
        int f = 0;
        int count = 1;
        while (rs.next()) {
            System.out.println(rs.getString(metaData1.getColumnName(1)));
            if (_table_name.getText().equals(rs.getString(metaData1.getColumnName(1))))
                f = 1;
            count++;
        }
        System.out.println("ooopp:" + f);
        if (f == 0) {
            JOptionPane.showMessageDialog(null, "NO SUCH TABLE");
        } else {
            JButton _select_button = new JButton("SELECT");
            final JCheckBox[] jCheckboxArray = new JCheckBox[100];
            System.out.println(tableeasy.MainActivity.usernames);
            String s2 = _table_name.getText().trim();
            String s1 = "select * from ";
            s2 = s1.concat(s2);
            System.out.println(s2);
            if (connector == null)
                JOptionPane.showMessageDialog(null, "NOT YET CONNECTED");
            else {
                try {
                    if (tableeasy.MainActivity.noofdata == 0) {
                        Databases d = new Databases();
                        d.setLocationRelativeTo(null);
                        d.setVisible(true);
                    } else {
                        final JFrame frame1 = new JFrame("SELECT COLOUMNS");
                        JLabel j = new JLabel("");
                        frame1.setSize(500, 400);
                        frame1.setVisible(true);
                        JPanel p = new JPanel();
                        p.setLayout(new GridBagLayout());
                        GridBagConstraints c = new GridBagConstraints();
                        frame1.setLocationRelativeTo(null);
                        String squery1 = "select * from tablesr where dbname='?'";
                        stmt = connector.prepareStatement(squery1);
                        stmt.setObject(1,tableeasy.MainActivity.databases[tableeasy.MainActivity.selecteddata]);
                        rs = stmt.executeQuery();
                        metaData1 = rs.getMetaData();
                        int fl = 0;
                        int counter = 1;
                        while (rs.next()) {
                            if (_table_name.getText().equals(rs.getString(metaData1.getColumnName(1))))
                                fl = 1;
                            counter++;
                        }
                        if (fl == 0) {
                            JOptionPane.showMessageDialog(null, "NO SUCH TABLE");
                        } else {
                            rs = stmt.executeQuery(s2);
                            ResultSetMetaData metaData = rs.getMetaData();
                            rwcnt = metaData.getColumnCount();
                            System.out.println(rwcnt);
                            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                                System.out.println(metaData.getColumnName(1));
                                jCheckboxArray[i] = new javax.swing.JCheckBox();
                                jCheckboxArray[i].setText(metaData.getColumnName(i));
                                jCheckboxArray[i].setVisible(true);
                                p.add(jCheckboxArray[i]);
                            }
                            p.add(_select_button);
                            JScrollPane pane = new JScrollPane(p);
                            frame1.add(pane);
                            pane.setVisible(true);
                            pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                        }
                        _select_button.addActionListener(new ActionListener() {

                            public void actionPerformed(ActionEvent e) {
                                frame1.dispose();
                                System.out.println("kko");
                                OracleDatabaseConnection conn = new OracleDatabaseConnection();
                                Connection connector = conn.checkLogin(conn.hostn, conn.portn, conn.databasen, conn.usern, conn.passn);
                                String[] s = new String[100];
                                String s2 = _table_name.getText().trim();
                                String s1 = "select ";
                                for (int i = 1; i <= rwcnt; i++) {
                                    if (jCheckboxArray[i].isSelected()) {
                                        s[i] = jCheckboxArray[i].getText();
                                        s1 = s1.concat(s[i]);
                                        s1 = s1.concat(",");
                                        System.out.println(s[i]);
                                    }
                                }
                                s1 = s1.substring(0, s1.length() - 1);
                                s1 = s1.concat(" from ");
                                s1 = s1.concat(s2);
                                System.out.println(s2);
                                q = s1;
                                if (connector == null)
                                    System.out.print("null");
                                else {
                                    System.out.print("not null");
                                    System.out.print(q);
                                    TableDetails screen = new TableDetails();
                                    screen.display();
                                    screen.setLocationRelativeTo(null);
                                    screen.setTitle(_table_name.getText());
                                    screen.setVisible(true);
                                }
                            }
                        });
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "NO SUCH TABLE");
                    Logger.getLogger(MainTabbedPane.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    } catch (SQLException ex) {
        Logger.getLogger(OtherQueries.class.getName()).log(Level.SEVERE, null, ex);
    }
}}

