class Dummy{
private void savePaymentActionPerformed(java.awt.event.ActionEvent evt) {
    String customer_id = get_customer_id();
    if (cardNumber.getText().isEmpty() || expDate.getText().isEmpty() || csc.getText().isEmpty() || nameOnCard.getText().isEmpty() || billing.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Error all fields must be filled");
    } else {
        try {
            c = ShopNow.openDB();
            stmt = c.createStatement();
            String sql = "INSERT INTO PAYMENT (CUSTOMER_ID, CREDIT_CARD_NUMBER, EXP_DATE, CID, NAME_ON_CARD, BILLING_ADDRESS) VALUES( " + customer_id + ", " + cardNumber.getText() + ", '" + expDate.getText() + "' , " + csc.getText() + ", '" + nameOnCard.getText() + "', '" + billing.getText() + "' );";
            stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "New Payement Added!");
            ShopNow.closeDB();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        new Customer_Account().setVisible(true);
        this.setVisible(false);
    }
}}

