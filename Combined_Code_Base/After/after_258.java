public class Dummy{
private void downloadFile() {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setInitialFileName(selFile.getDocname());
    File file = fileChooser.showSaveDialog(currentStage);
    if (file != null) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String dwnQuery = "SELECT docfile FROM document WHERE iddocument = ?";
            PreparedStatement ps = connection.prepareStatement(dwnQuery);
            ps.setObject(1, selFile.getDocid());
            ResultSet rs = ps.executeQuery();
            rs.next();
            Blob imageBlob = rs.getBlob(1);
            InputStream is = imageBlob.getBinaryStream();
            FileOutputStream fos = new FileOutputStream(file);
            int bytes = 0;
            while ((bytes = is.read()) != -1) {
                fos.write(bytes);
            }
            fos.close();
            connection.close();
            ps.close();
            rs.close();
        } catch (IOException e) {
            System.out.print("IOException");
            Alert sqlAlert = new Alert(Alert.AlertType.ERROR);
            sqlAlert.setTitle("Error downloading file from database");
            sqlAlert.setHeaderText(null);
            sqlAlert.setContentText("The program encountered an error and couldn't download the file, check your connection and please try again");
            sqlAlert.showAndWait();
        } catch (SQLException e) {
            Alert sqlAlert = new Alert(Alert.AlertType.ERROR);
            sqlAlert.setTitle("Error downloading file from database");
            sqlAlert.setHeaderText(null);
            sqlAlert.setContentText("The program encountered an error and couldn't download the file, check your connection and please try again");
            sqlAlert.showAndWait();
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }
}}

