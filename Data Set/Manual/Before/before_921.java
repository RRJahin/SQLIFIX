public class Dummy{
private void insertActionPerformed(java.awt.event.ActionEvent evt) {
    try {
        Statement stmt;
        OracleDatabaseConnection conn = new OracleDatabaseConnection();
        Connection connector = conn.checkLogin(conn.hostn, conn.portn, conn.databasen, conn.usern, conn.passn);
        stmt = connector.createStatement();
        String squery = "select * from tablesr where dbname='" + tableeasy.MainActivity.databases[tableeasy.MainActivity.selecteddata] + "'";
        System.out.println(tableeasy.MainActivity.databases[tableeasy.MainActivity.selecteddata]);
        ResultSet rs = stmt.executeQuery(squery);
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
            JFrame frame = new JFrame("INSERT INTO");
            JLabel j = new JLabel("");
            frame.setSize(500, 400);
            frame.setVisible(true);
            JPanel p = new JPanel();
            p.setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            frame.setLocationRelativeTo(null);
            JLabel[] jl = new JLabel[100];
            final JTextField[] jt = new JTextField[100];
            JButton jb = new JButton("INSERT");
            String s = _table_name.getText();
            String s1 = "select * from ";
            s = s1.concat(s);
            System.out.println(s);
            if (connector == null)
                JOptionPane.showMessageDialog(null, "NOT YET CONNECTED");
            else {
                try {
                    stmt = connector.createStatement();
                    rs = stmt.executeQuery(s);
                    final ResultSetMetaData metaData = rs.getMetaData();
                    final int colcnt = metaData.getColumnCount();
                    for (int i = 1; i <= metaData.getColumnCount(); i++) {
                        jl[i] = new JLabel(metaData.getColumnName(i));
                        jt[i] = new JTextField();
                        jt[i].setPreferredSize(new Dimension(300, 20));
                        final int k = i;
                        jt[i].setText(metaData.getColumnTypeName(i));
                        jt[i].addMouseListener(new MouseAdapter() {

                            @Override
                            public void mouseClicked(MouseEvent e) {
                                jt[k].setText("");
                            }
                        });
                        c.gridx = 0;
                        c.gridy = i;
                        p.add(jl[i], c);
                        c.gridx = 2;
                        c.gridy = i;
                        p.add(jt[i], c);
                        p.add(Box.createVerticalStrut(-10));
                        jt[i].setVisible(true);
                        jl[i].setVisible(true);
                    }
                    c.gridx = 2;
                    c.gridy = metaData.getColumnCount() + 4;
                    jb.setBounds(150, 200, 200, 200);
                    p.add(jb, c);
                    JScrollPane pane = new JScrollPane(p);
                    frame.add(pane);
                    pane.setVisible(true);
                    pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                    jb.addActionListener(new ActionListener() {

                        public void actionPerformed(ActionEvent e) {
                            String s1 = "insert into " + _table_name.getText() + " values(";
                            String s2 = "";
                            String s9 = "";
                            for (int i = 1; i <= colcnt; i++) {
                                s9 = jt[i].getText();
                                if (!isInteger(s9)) {
                                    s9 = "'" + s9 + "'";
                                }
                                s2 = s2.concat(s9);
                                s2 = s2 + ",";
                            }
                            s2 = s2.substring(0, s2.length() - 1);
                            s2 = s2 + ")";
                            s1 = s1.concat(s2);
                            System.out.print(s1);
                            OracleDatabaseConnection conn = new OracleDatabaseConnection();
                            Connection connector = conn.checkLogin(conn.hostn, conn.portn, conn.databasen, conn.usern, conn.passn);
                            try {
                                Statement statement = connector.createStatement();
                                statement.execute(s1);
                                JOptionPane.showMessageDialog(null, "VALUE INSERTED");
                            } catch (SQLException ex) {
                                JOptionPane.showMessageDialog(null, "UNABLE TO INSERT");
                                Logger.getLogger(OtherQueries.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    });
                } catch (SQLException ex) {
                    Logger.getLogger(OtherQueries.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    } catch (SQLException ex) {
        Logger.getLogger(OtherQueries.class.getName()).log(Level.SEVERE, null, ex);
    }
}}

