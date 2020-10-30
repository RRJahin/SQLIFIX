public class Dummy{
private void previewFile() {
    Platform.runLater(() -> {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String prevQuery = "SELECT docfile FROM document WHERE iddocument = ?";
            PreparedStatement ps = connection.prepareStatement(prevQuery);
            ps.setObject(1, selFile.getDocid());
            ResultSet rs = ps.executeQuery();
            rs.next();
            Blob imageBlob = rs.getBlob(1);
            InputStream is = imageBlob.getBinaryStream();
            BufferedImage image = ImageIO.read(is);
            Image disimage = SwingFXUtils.toFXImage(image, null);
            double imheight = disimage.getHeight();
            double imwidth = disimage.getWidth();
            ImageView imageView = new ImageView(disimage);
            AnchorPane previewPage = new AnchorPane();
            previewPage.getChildren().addAll(imageView);
            Scene scene = new Scene(previewPage, imwidth, imheight);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle(selFile.getDocname());
            stage.show();
        } catch (IOException e) {
            System.out.print("IOException");
            Alert sqlAlert = new Alert(Alert.AlertType.ERROR);
            sqlAlert.setTitle("Error previewing image");
            sqlAlert.setHeaderText(null);
            sqlAlert.setContentText("The program encountered an error and couldn't preview the image, check your connection and please try again");
            sqlAlert.showAndWait();
        } catch (SQLException e) {
            Alert sqlAlert = new Alert(Alert.AlertType.ERROR);
            sqlAlert.setTitle("Error previewing image");
            sqlAlert.setHeaderText(null);
            sqlAlert.setContentText("The program encountered an error and couldn't preview the image, check your connection and please try again");
            sqlAlert.showAndWait();
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    });
}}

