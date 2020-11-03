class Dummy{
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    DefaultTableModel model = (DefaultTableModel) flightt.getModel();
    try {
        Class.forName("java.sql.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/airline_reservation?verifyServerCertificate=false&useSSL=true", "root", "pragun");
        stmt = con.createStatement();
        String query = "Select * from flights Where ID =" + fid.getText() + ";";
        rs = stmt.executeQuery(query);
        if (rs.next()) {
            String name = rs.getString("Name");
            String id = rs.getString("ID");
            String departure = rs.getString("Departure");
            String arrival = rs.getString("Arrival");
            String source = rs.getString("Source");
            String destination = rs.getString("Destination");
            String charges = rs.getString("Charges");
            String date = rs.getString("Date");
            model.addRow(new Object[] { id, name, source, destination, departure, arrival, charges, date });
            fid.setText(id);
            fname.setText(name);
            fdep.setText(departure);
            farrival.setText(arrival);
            fsource.setText(source);
            fdest.setText(destination);
            fcharges.setText(charges);
            fdate.setText(date);
        } else
            JOptionPane.showMessageDialog(null, "No such flight");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error in connectivity");
    }
    del.setEnabled(true);
    up.setEnabled(true);
}}

