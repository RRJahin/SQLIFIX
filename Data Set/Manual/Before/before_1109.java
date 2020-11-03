public class Dummy{
@FXML
void handleRemoveInstr(ActionEvent event) {
    Instructor curInstr = instructorTableView.getSelectionModel().getSelectedItem();
    if (curInstr != null) {
        Alert deleteAlert = new Alert(Alert.AlertType.CONFIRMATION);
        deleteAlert.setTitle("Delete This Instructor?");
        deleteAlert.setHeaderText(null);
        deleteAlert.setContentText("Are you sure you want to delete this instructor?");
        Optional<ButtonType> result = deleteAlert.showAndWait();
        if (result.get() == ButtonType.OK) {
            String deleteInstr = "DELETE FROM instructor WHERE idinstructor = "+curInstr.getInstrId();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                Statement ps = connection.createStatement();
                ps.executeUpdate(deleteInstr);
                ps.close();
                connection.close();
            } catch (SQLException e) {
                Alert sqlAlert = new Alert(Alert.AlertType.ERROR);
                sqlAlert.setTitle("Error removing instructor");
                sqlAlert.setHeaderText(null);
                sqlAlert.setContentText("The program encountered an error and couldn't remove the instructor, check your connection and please try again");
                sqlAlert.showAndWait();
                throw new IllegalStateException("Cannot connect the database!", e);
            }
        }
    } else {
        Alert noSelAlert = new Alert(Alert.AlertType.WARNING);
        noSelAlert.setTitle("No instructor selected");
        noSelAlert.setHeaderText(null);
        noSelAlert.setContentText("Please select an instructor before clicking remove");
        noSelAlert.showAndWait();
    }
    reloadInstructors();
}}

