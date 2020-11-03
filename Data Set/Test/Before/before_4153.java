class Dummy{
private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
    try {
        Class.forName("java.sql.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/airline_reservation?verifyServerCertificate=false&useSSL=true", "root", "pragun");
        stmt = con.createStatement();
        String query = "Delete from tickets where TicketNo =" + ticketx.getText() + ";";
        stmt.executeUpdate(query);
        JOptionPane.showMessageDialog(null, "Ticket Cancelled");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error in Connectivity");
    }
}}

