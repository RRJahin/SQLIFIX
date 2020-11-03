class Dummy{
private void deletePaymentActionPerformed(java.awt.event.ActionEvent evt) {
    String id = get_customer_id();
    Boolean records = payment_exists();
    Boolean check = false;
    try {
        c = ShopNow.openDB();
        stmt = c.createStatement();
        if (!records) {
            JOptionPane.showMessageDialog(null, "No Payment Method Exists!");
        } else {
            String sql = "DELETE FROM PAYMENT WHERE CUSTOMER_ID = " + id + ";";
            stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Payement has been Deleted!");
            check = true;
        }
        ShopNow.closeDB();
        if (check == true) {
            new Customer_Account().setVisible(true);
            this.setVisible(false);
        }
    } catch (Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
        System.exit(0);
    }
}}

