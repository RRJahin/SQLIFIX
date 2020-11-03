class Dummy{
@Override
public void actionPerformed(ActionEvent e) {
    String sq = "select * from usersr where userid=" + MainActivity.usernames;
    try {
        Statement st = OracleDatabaseConnection.connect.createStatement();
        ResultSet rs123 = st.executeQuery(sq);
        String sname = new String();
        String spass = new String();
        while (rs123.next()) {
            sname = rs123.getString("username");
            spass = rs123.getString("password");
        }
        String sq1 = "insert into passwordsr values('" + sname + "','" + spass + "')";
st = OracleDatabaseConnection.connect.createStatement();
        int r = st.executeUpdate(sq1);
    } catch (SQLException ex) {
        Logger.getLogger(Table.class.getName()).log(Level.SEVERE, null, ex);
    }
}}

