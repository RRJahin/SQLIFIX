class Dummy{
public void actionPerformed(ActionEvent e) {
    try {
        select_databases.dispose();
        OracleDatabaseConnection conn = new OracleDatabaseConnection();
        Connection connector = conn.checkLogin(conn.hostn, conn.portn, conn.databasen, conn.usern, conn.passn);
        Statement stmt2 = connector.createStatement();
        System.out.println("nmnmnmnm:" + klo);
        ResultSet rs90 = stmt2.executeQuery("select * from tablesr");
        int dk = 1;
        while (rs90.next()) {
            dk++;
        }
        String[] s1 = new String[100];
        for (int i = 1; i < klo; i++) {
            if (ckdb[i].isSelected()) {
                s1[i] = ckdb[i].getText();
                System.out.println(s1[i]);
                String _insert_table = "insert into tablesr values('" + _table_name + "'," + _col_no + "," + dk + ",'" + s1[i] + "')";
                try {
stmt2 = connector.createStatement();
                    stmt2.executeQuery(_insert_table);
                } catch (SQLException ex) {
                    Logger.getLogger(TableCreationBox.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    } catch (SQLException ex) {
        Logger.getLogger(TableCreationBox.class.getName()).log(Level.SEVERE, null, ex);
    }
}}

