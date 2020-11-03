class Dummy{
private void list_typeActionPerformed(java.awt.event.ActionEvent evt) {
    Connection con = null;
    try {
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        con = DriverManager.getConnection(url, user, pass);
        String sql = "SELECT name from items where type ='" + list_type.getSelectedItem() + "'";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        list_name.removeAll();
        while (rs.next()) {
            String type = rs.getString("name");
            list_name.add(type);
        }
        con.close();
    } catch (Exception ex) {
        System.err.println(ex);
    }
}}

