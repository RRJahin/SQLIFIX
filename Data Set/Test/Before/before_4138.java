class Dummy{
private void submitActionPerformed(java.awt.event.ActionEvent evt) {
    String fullname = newName.getText();
    String email = newEmail.getText();
    String phone = newPhoneNumber.getText();
    String password = newPassword.getText();
    if (fullname == null || email == null || phone == null || password == null) {
        JOptionPane.showMessageDialog(null, "Error all fields must be filled");
    } else {
        String[] name = fullname.split("\\s+");
        if (name[0] == null || name[1] == null) {
            System.out.println("Please Enter Both first and last names");
        } else {
            try {
                c = ShopNow.openDB();
                stmt = c.createStatement();
                password = Security.encrypt(password);
                String sql = "UPDATE CUSTOMER SET FIRST_NAME = '" + name[0] + "', LAST_NAME = '" + name[1] + "', EMAIL = '" + email + "', PHONE = '" + phone + "', PASSWORD = '" + password + "' WHERE EMAIL = '" + Login.sendUsername() + "';";
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "UPDATE Successful!");
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
            ShopNow.closeDB();
            JFrame s = new Login();
            s.setVisible(true);
            s.setLocationRelativeTo(null);
            this.setVisible(false);
        }
    }
}}

