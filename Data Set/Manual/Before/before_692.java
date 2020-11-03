public class Dummy{
private void createbuttonActionPerformed(java.awt.event.ActionEvent evt) {
    String s = databasename1.getText();
    OracleDatabaseConnection conn = new OracleDatabaseConnection();
    final Connection connector = conn.checkLogin(conn.hostn, conn.portn, conn.databasen, conn.usern, conn.passn);
    Statement stmt1;
    int fl = 0;
    try {
        stmt1 = connector.createStatement();
        ResultSet rs90 = stmt1.executeQuery("select * from databaser");
        ResultSetMetaData metaData = rs90.getMetaData();
        int d = 1;
        while (rs90.next()) {
            d++;
            if (databasename1.getText() == rs90.getString(metaData.getColumnName(1))) {
                fl = 1;
            }
        }
    } catch (SQLException ex) {
        Logger.getLogger(Databases.class.getName()).log(Level.SEVERE, null, ex);
    }
    dispose();
    if (fl == 0) {
        JFrame f = new JFrame("DATABASE MONITOR");
        JLabel n = new JLabel(s);
        JButton jb = new JButton("create with these users");
        final JCheckBox[] jl = new JCheckBox[100];
        f.setSize(500, 400);
        f.setVisible(true);
        JPanel p = new JPanel();
        p.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        f.setLocationRelativeTo(null);
        String s1 = "select * from ";
        s = s1.concat("usersr");
        System.out.println(s);
        try {
            Statement stmt;
            stmt = connector.createStatement();
            int i = 1;
            ResultSet rs = stmt.executeQuery(s);
            final ResultSetMetaData metaData = rs.getMetaData();
            final int colcnt = metaData.getColumnCount();
            while (rs.next()) {
                jl[i] = new JCheckBox(rs.getString(metaData.getColumnName(1)));
                c.gridx = 0;
                c.gridy = i;
                p.add(jl[i], c);
                p.add(Box.createVerticalStrut(-10));
                jl[i].setVisible(true);
                i++;
            }
            final int ef = i;
            c.gridx = 1;
            c.gridy = i + 1;
            jb.setBounds(150, 200, 200, 200);
            p.add(jb, c);
            JScrollPane pane = new JScrollPane(p);
            f.add(pane);
            pane.setVisible(true);
            pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            jb.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    try {
                        Statement stmt1;
                        stmt1 = connector.createStatement();
                        String s = "";
                        ResultSet rs90 = stmt1.executeQuery("select distinct dbname from databaser");
                        int d = 1;
                        while (rs90.next()) {
                            d++;
                        }
                        System.out.println("sdfsdfs here goes the databaseid::  " + d);
                        int ids = 0;
                        Statement stmt = connector.createStatement();
                        for (int i = 1; i < ef; i++) {
                            if (jl[i].isSelected()) {
                                try {
                                    s = jl[i].getText();
                                    String snewer = "select userid from usersr where username='" + s + "'";
                                    ResultSet rs = stmt.executeQuery(snewer);
                                    while (rs.next()) {
                                        final ResultSetMetaData metaData = rs.getMetaData();
                                        ids = Integer.parseInt(rs.getString(metaData.getColumnName(1)));
                                    }
                                    System.out.println(ids);
                                } catch (SQLException ex) {
                                    Logger.getLogger(Databases.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                String sqee = "insert into databaser values('" + databasename1.getText() + "'," + ef + "," + d + "," + ids + ")";
                                stmt.executeUpdate(sqee);
                                System.out.println(ids);
                            }
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Databases.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
        } catch (SQLException ex) {
            Logger.getLogger(OtherQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
    } else {
        JOptionPane.showMessageDialog(null, "DATABASE ALREADY EXISTS");
    }
}}

