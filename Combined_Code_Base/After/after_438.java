public class Dummy{
@FXML
void handleAddInstr(ActionEvent event) {
    if (isInstrInputsValid()) {
        String addInstrQuery = "INSERT INTO instructor(fname,lname,faculty,email,password) VALUES (?,?,?,?,?)";
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            PreparedStatement ps = connection.prepareStatement(addInstrQuery);
            ps.setObject(1, firstNameTextBox.getText());
            ps.setObject(2, lastNameTextBox.getText());
            ps.setObject(3, facultyInstrTextBox.getText());
            ps.setObject(4, emailTextBox.getText());
            ps.setObject(5, BCrypt.hashpw(passBox.getText(), BCrypt.gensalt()));
            ps.executeUpdate();
            ps.close();
            connection.close();
            firstNameTextBox.clear();
            lastNameTextBox.clear();
            facultyInstrTextBox.clear();
            emailTextBox.clear();
            passBox.clear();
        } catch (SQLException e) {
            int errorCode = e.getErrorCode();
            if (errorCode == 1062) {
                Alert alreadyAlert = new Alert(Alert.AlertType.ERROR);
                alreadyAlert.setTitle("This email already exists");
                alreadyAlert.setHeaderText(null);
                alreadyAlert.setContentText("This email already exists, please use another email");
                alreadyAlert.showAndWait();
            } else {
                Alert sqlAlert = new Alert(Alert.AlertType.ERROR);
                sqlAlert.setTitle("Error adding instructor");
                sqlAlert.setHeaderText(null);
                sqlAlert.setContentText("The program encountered an error and couldn't add the instructor, check your connection and please try again");
                sqlAlert.showAndWait();
            }
        }
    }
    reloadInstructors();
}}

