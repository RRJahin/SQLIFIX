class Dummy{
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    try {
        Class.forName("java.sql.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/airline_reservation?verifyServerCertificate=false&useSSL=true", "root", "pragun");
        stmt = con.createStatement();
        String query = "Select * from tickets Where TicketNo =" + ticketx.getText() + ";";
        rs = stmt.executeQuery(query);
        if (rs.next()) {
            String name1 = rs.getString("FlightName");
            String name2 = rs.getString("CustomerName");
            String date1 = rs.getString("Date");
            fname.setText(name1);
            custname.setText(name2);
            fdate.setText(date1);
        } else {
            JOptionPane.showMessageDialog(null, "No such record found");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error in Connectivity");
    }
}}

