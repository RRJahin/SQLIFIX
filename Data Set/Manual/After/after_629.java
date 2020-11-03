class Dummy{
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    try {
        Class.forName("java.sql.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/airline_reservation?verifyServerCertificate=false&useSSL=true", "root", "pragun");
        String query = "Select * from tickets Where TicketNo =?;";
        stmt = con.prepareStatement(query);
        stmt.setObject(1,ticketx.getText());
        rs = stmt.executeQuery();
        if (rs.next()) {
            String name1 = rs.getString("FlightName");
            String gender2 = rs.getString("Gender");
            String name2 = rs.getString("CustomerName");
            String source1 = rs.getString("Source");
            String dest1 = rs.getString("Destination");
            String date1 = rs.getString("Date");
            String id1 = rs.getString("FlightID");
            String id2 = rs.getString("CustomerID");
            String seats1 = rs.getString("Seats");
            String amount1 = rs.getString("Amount");
            fid.setText(id1);
            fname.setText(name1);
            custname.setText(name2);
            custid.setText(id2);
            fsource.setText(source1);
            fdest.setText(dest1);
            fdate.setText(date1);
            amountx.setText(amount1);
            seatsx.setText(seats1);
            if (gender2.equals("male"))
                male1.setSelected(true);
            else if (gender2.equals("female"))
                female1.setSelected(true);
        } else {
            JOptionPane.showMessageDialog(null, "No such record found");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error in Connectivity");
    }
}}

