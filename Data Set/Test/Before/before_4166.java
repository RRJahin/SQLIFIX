class Dummy{
private void updatePaymentActionPerformed(java.awt.event.ActionEvent evt) {
    String customer_id = get_customer_id();
    if (newCardNumber.getText().isEmpty() || newExpDate.getText().isEmpty() || newCID.getText().isEmpty() || newNameOnCard.getText().isEmpty() || newBilling.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Error all fields must be filled");
    } else {
        try {
            c = ShopNow.openDB();
            stmt = c.createStatement();
            String sql = "UPDATE PAYMENT SET CREDIT_CARD_NUMBER = " + newCardNumber.getText() + ", EXP_DATE = '" + newExpDate.getText() + "', CID = " + newCID.getText() + ", NAME_ON_CARD = '" + newNameOnCard.getText() + "', BILLING_ADDRESS = '" + newBilling.getText() + "' WHERE CUSTOMER_ID = " + customer_id + ";";
            stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Payement has been Updated!");
            ShopNow.closeDB();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        new Customer_Account().setVisible(true);
        this.setVisible(false);
    }
}}

