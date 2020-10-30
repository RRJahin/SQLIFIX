public class Dummy{
@FXML
void handleAdd(ActionEvent event) {
    if (isCourInputsValid()) {
        String addCourQuery = "INSERT INTO course(courname,faculty) VALUES (?,?)";
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            PreparedStatement ps = connection.prepareStatement(addCourQuery);
            String courname = formatString(courseNameTextBox.getText());
            ps.setObject(1, courname);
            ps.setObject(2, facultyCourTextBox.getText());
            ps.executeUpdate();
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

