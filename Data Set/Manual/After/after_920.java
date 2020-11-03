public class Dummy{
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
        PreparedStatement statement = connector.prepareStatement(s1);
        statement.execute();
        JOptionPane.showMessageDialog(null, "VALUE INSERTED");
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "UNABLE TO INSERT");
        Logger.getLogger(OtherQueries.class.getName()).log(Level.SEVERE, null, ex);
    }
}}

