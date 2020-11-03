public class Dummy{
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
}}

