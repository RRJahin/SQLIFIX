public class Dummy{
@FXML
void handleRemove(ActionEvent event) {
    Courses curCour = courseTableView.getSelectionModel().getSelectedItem();
    if (curCour != null) {
        Alert deleteAlert = new Alert(Alert.AlertType.CONFIRMATION);
        deleteAlert.setTitle("Delete This Course?");
        deleteAlert.setHeaderText(null);
        deleteAlert.setContentText("Are you sure you want to delete this course?");
        Optional<ButtonType> result = deleteAlert.showAndWait();
        if (result.get() == ButtonType.OK) {
            String deleteCourse = "DELETE FROM course WHERE idcourse = "+curCour.getId();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                Statement ps = connection.createStatement();
                ps.executeUpdate(deleteCourse);
                ps.close();
                connection.close();
            } catch (SQLException e) {
                Alert sqlAlert = new Alert(Alert.AlertType.ERROR);
                sqlAlert.setTitle("Error removing course");
                sqlAlert.setHeaderText(null);
                sqlAlert.setContentText("The program encountered an error and couldn't remove the course, check your connection and please try again");
                sqlAlert.showAndWait();
                throw new IllegalStateException("Cannot connect the database!", e);
            }
        }
    } else {
        Alert noSelAlert = new Alert(Alert.AlertType.WARNING);
        noSelAlert.setTitle("No course selected");
        noSelAlert.setHeaderText(null);
        noSelAlert.setContentText("Please select a course before clicking remove");
        noSelAlert.showAndWait();
    }
    reloadCourse();
}}

