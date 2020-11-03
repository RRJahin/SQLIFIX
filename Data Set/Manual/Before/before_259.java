public class Dummy{
private void deleteFile() {
    Alert deleteAlert = new Alert(Alert.AlertType.CONFIRMATION);
    deleteAlert.setTitle("Delete This File?");
    deleteAlert.setHeaderText("You are about to delete " + selFile.getDocname());
    deleteAlert.setContentText("Are you sure you want to delete this file?");
    String deleteQuery = "DELETE FROM document WHERE iddocument NOT IN (SELECT iddocument FROM instrcourdoc);";
    String deleteInterQuery = "DELETE FROM instrcourdoc WHERE iddocument = "+selFile.getDocid()+" AND idinstructor = "+instrId+" AND idcourse = "+courseId+" ;";
    String deleteTagQuery = "DELETE FROM tag WHERE idtag NOT IN(SELECT idtag FROM doctag)";
    Optional<ButtonType> result = deleteAlert.showAndWait();
    if (result.get() == ButtonType.OK) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Integer courseId = selCourse.getId();
            connection.setAutoCommit(false);
            Statement ps1 = connection.createStatement();
            ps1.executeUpdate(deleteInterQuery);
            ps1.close();
            Statement ps = connection.createStatement();
            ps.executeUpdate(deleteQuery);
            ps.close();
            Statement psIntTag = connection.createStatement();
            psIntTag.executeUpdate(deleteTagQuery);
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

