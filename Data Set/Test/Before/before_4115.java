class Dummy{
private void loadActionPerformed(java.awt.event.ActionEvent evt) {
    Connection con = null;
    try {
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        con = DriverManager.getConnection(url, user, pass);
        String sql = "SELECT name from items where item_code not in (select item_code from produces where id =" + vid + ")";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            String name = rs.getString("name");
            list.add(name);
        }
        con.close();
    } catch (Exception ex) {
        System.err.println(ex);
    }
}}

