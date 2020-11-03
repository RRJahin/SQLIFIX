public class Dummy{
private void deleteFile() {
    Alert deleteAlert = new Alert(Alert.AlertType.CONFIRMATION);
    deleteAlert.setTitle("Delete This File?");
    deleteAlert.setHeaderText("You are about to delete " + selFile.getDocname());
    deleteAlert.setContentText("Are you sure you want to delete this file?");
    String deleteQuery = "DELETE FROM document WHERE iddocument NOT IN (SELECT iddocument FROM instrcourdoc);";
    String deleteInterQuery = "DELETE FROM instrcourdoc WHERE iddocument = ? AND idinstructor = ? AND idcourse = ? ;";
    String deleteTagQuery = "DELETE FROM tag WHERE idtag NOT IN(SELECT idtag FROM doctag)";
    Optional<ButtonType> result = deleteAlert.showAndWait();
    if (result.get() == ButtonType.OK) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Integer courseId = selCourse.getId();
            connection.setAutoCommit(false);
            PreparedStatement ps1 = connection.prepareStatement(deleteInterQuery);
            ps1.setObject(1, selFile.getDocid());
            ps1.setObject(2, instrId);
            ps1.setObject(3, courseId);
            ps1.executeUpdate();
            ps1.close();
            PreparedStatement ps = connection.prepareStatement(deleteQuery);
            ps.executeUpdate();
            ps.close();
            PreparedStatement psIntTag = connection.prepareStatement(deleteTagQuery);
            psIntTag.executeUpdate();
            psIntTag.close();
            connection.commit();
            connection.setAutoCommit(true);
            connection.close();
        } catch (SQLException e) {
            Alert sqlAlert = new Alert(Alert.AlertType.ERROR);
            sqlAlert.setTitle("Error deleting file");
            sqlAlert.setHeaderText(null);
            sqlAlert.setContentText("The program encountered an error and couldn't delete the file, check your connection and please try again");
            sqlAlert.showAndWait();
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    } else {
        deleteAlert.close();
    }
    loadData();
    runPage();
}}

