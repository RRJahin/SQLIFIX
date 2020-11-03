public class Dummy{
private void pdfPreview() {
    try (Connection connection = DriverManager.getConnection(url, username, password)) {
        String prevQuery = "SELECT title,docfile FROM document WHERE iddocument = "+selFile.getDocid();
        Statement ps = connection.createStatement();
        ResultSet rs = ps.executeQuery(prevQuery);
        rs.next();
        String filename = rs.getString(1);
        Blob imageBlob = rs.getBlob(2);
        String prefix = FilenameUtils.removeExtension(filename);
        InputStream is = imageBlob.getBinaryStream();
        File tempFile = File.createTempFile(prefix, ".pdf");
        tempFile.deleteOnExit();
        FileOutputStream out = new FileOutputStream(tempFile);
        IOUtils.copy(is, out);
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().open(tempFile);
            } catch (IOException ex) {
                Alert pdfAlert = new Alert(Alert.AlertType.ERROR);
                pdfAlert.setTitle("No pdf program");
                pdfAlert.setHeaderText(null);
                pdfAlert.setContentText("There are not programs present on this computer that can open the current file");
                pdfAlert.showAndWait();
            }
        } else {
            Alert pdfNotSupAlert = new Alert(Alert.AlertType.ERROR);
            pdfNotSupAlert.setTitle("This action is not supported");
            pdfNotSupAlert.setHeaderText(null);
            pdfNotSupAlert.setContentText("This action is not supported on your device");
            pdfNotSupAlert.showAndWait();
        }
    } catch (IOException e) {
        System.out.print("IOException");
        Alert sqlAlert = new Alert(Alert.AlertType.ERROR);
        sqlAlert.setTitle("Error previewing pdf");
        sqlAlert.setHeaderText(null);
        sqlAlert.setContentText("The program encountered an error and couldn't preview the pdf, check your connection and please try again");
        sqlAlert.showAndWait();
    } catch (SQLException e) {
        Alert sqlAlert = new Alert(Alert.AlertType.ERROR);
        sqlAlert.setTitle("Error previewing pdf");
        sqlAlert.setHeaderText(null);
        sqlAlert.setContentText("The program encountered an error and couldn't preview the pdf, check your connection and please try again");
        sqlAlert.showAndWait();
        throw new IllegalStateException("Cannot connect the database!", e);
    }
}}

