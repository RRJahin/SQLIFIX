class Dummy{
public void actionPerformed(ActionEvent e) {
    if (connector != null) {
        try {
            Statement stmt1;
            stmt1 = connector.createStatement();
            ResultSet rs90 = stmt1.executeQuery("select * from usersr");
            int d = 1;
            while (rs90.next()) {
                d++;
            }
            if ((_username_textfield.getText().equals("")) || (_password_textfield.getText().equals(""))) {
                JOptionPane.showMessageDialog(null, "Invalid username and password");
            } else {
                System.out.println(d);
                String sins = "insert into usersr values('" + _username_textfield.getText() + "'" + "," + d + "," + "'" + _password_textfield.getText() + "')";
                PreparedStatement statement = connect.prepareStatement(sins);
statement = connector.createStatement();
                statement.execute();
                dispose();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Invalid username and password");
            Logger.getLogger(UserCreation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}}

