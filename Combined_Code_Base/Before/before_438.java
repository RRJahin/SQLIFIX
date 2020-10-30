public class Dummy{
@FXML
void handleAddInstr(ActionEvent event) {
    if (isInstrInputsValid()) {
        String addInstrQuery = "INSERT INTO instructor(fname,lname,faculty,email,password)  VALUES ("+firstNameTextBox.getText()+","+lastNameTextBox.getText()+","+facultyInstrTextBox.getText()+","+emailTextBox.getText()+","+ BCrypt.hashpw(passBox.getText(), BCrypt.gensalt())+")";
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement ps = connection.createStatement();
            ps.executeUpdate(addInstrQuery);
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

