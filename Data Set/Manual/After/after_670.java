public class Dummy{
@FXML
void handleOk(ActionEvent event) {
    if (checkInput()) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            courseId = copyComboBox.getSelectionModel().getSelectedItem().getId();
            String checkCourQuery = "SELECT count(*) FROM instrcourdoc where instrcourdoc.iddocument = ?" + " AND instrcourdoc.idcourse = ? AND instrcourdoc.idinstructor = ?;";
            PreparedStatement ps = connection.prepareStatement(checkCourQuery);
            ps.setObject(1, docId);
            ps.setObject(2, courseId);
            ps.setObject(3, instrId);
            ResultSet rs = ps.executeQuery();
            rs.next();
            Integer dupVal = rs.getInt(1);
            connection.setAutoCommit(false);
            if (dupVal > 0) {
                selFileName = checkFileName(connection, selFileName);
                String newQuery = "INSERT INTO document (title,docdesc,filetype,uploader,uploaddate,docfile) " + "SELECT ?, docdesc, filetype, uploader, uploaddate, docfile FROM document where iddocument = ?";
                PreparedStatement psNew = connection.prepareStatement(newQuery);
                psNew.setObject(1, selFileName);
                psNew.setObject(2, docId);
                psNew.executeUpdate();
                ResultSet keys = psNew.getGeneratedKeys();
                keys.next();
                Integer oldDocId = docId;
                docId = keys.getInt(1);
                transferTags(connection, oldDocId, docId);
                copyComboBox.getSelectionModel().clearSelection();
            }
            String instrCourDocQuery = "INSERT INTO instrcourdoc (idinstructor,idcourse,iddocument) " + "VALUES (?,?,?)";
            PreparedStatement psCD = connection.prepareStatement(instrCourDocQuery);
            psCD.setObject(1, instrId);
            psCD.setObject(2, courseId);
            psCD.setObject(3, docId);
            psCD.executeUpdate();
            successAlert();
            ps.close();
            rs.close();
            connection.commit();
            connection.setAutoCommit(true);
            connection.close();
        } catch (SQLException e) {
            Alert sqlAlert = new Alert(Alert.AlertType.ERROR);
            sqlAlert.setTitle("Error copying file");
            sqlAlert.setHeaderText(null);
            sqlAlert.setContentText("The program encountered an error and couldn't copy the file, check your connection and please try again");
            sqlAlert.showAndWait();
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }
    Stage currStage = (Stage) okButton.getScene().getWindow();
    currStage.close();
}}

