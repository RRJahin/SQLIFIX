public class Dummy{
@FXML
void handleAdd(ActionEvent event) {
    if (isCourInputsValid()) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement ps = connection.createStatement();
            String courname = formatString(courseNameTextBox.getText());
            String addCourQuery = "INSERT INTO course(courname,faculty) VALUES ("+courname+","+facultyCourTextBox.getText()+")";
            ps.executeUpdate(addCourQuery);
            ps.close();
            connection.close();
            courseNameTextBox.clear();
            facultyCourTextBox.clear();
        } catch (SQLException e) {
            int errorCode = e.getErrorCode();
            if (errorCode == 1062) {
                Alert alreadyAlert = new Alert(Alert.AlertType.ERROR);
                alreadyAlert.setTitle("This course already exists");
                alreadyAlert.setHeaderText(null);
                alreadyAlert.setContentText("This course already exists, please use another course name");
                alreadyAlert.showAndWait();
            } else {
                Alert sqlAlert = new Alert(Alert.AlertType.ERROR);
                sqlAlert.setTitle("Error adding course");
                sqlAlert.setHeaderText(null);
                sqlAlert.setContentText("The program encountered an error and couldn't add the course, check your connection and please try again");
                sqlAlert.showAndWait();
            }
        }
    }
    reloadCourse();
}}

