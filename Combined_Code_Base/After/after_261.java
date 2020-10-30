public class Dummy{
public ObservableList<DocFile> queryFiles(String courseName) {
    String fileQueryStr = "SELECT document.iddocument,title,uploader,uploaddate,filetype FROM instructor,document,course,instrcourdoc WHERE " + "instructor.idinstructor = instrcourdoc.idinstructor AND instrcourdoc.iddocument = document.iddocument AND " + "instrcourdoc.iddocument = document.iddocument AND instrcourdoc.idcourse = course.idcourse AND course.courname = ?" + "AND instructor.idinstructor = ? ORDER BY uploaddate DESC";
    try (Connection connection = DriverManager.getConnection(url, username, password)) {
        PreparedStatement preparedStatement = connection.prepareStatement(fileQueryStr);
        preparedStatement.setObject(1, courseName);
        preparedStatement.setObject(2, instrId);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            Integer curFileID = rs.getInt(1);
            String curFileTitle = rs.getString(2);
            String curFileUploader = rs.getString(3);
            Date curUploadDate = rs.getDate(4);
            String curFileType = rs.getString(5);
            fileList.add(new DocFile(curFileID, curFileTitle, curFileUploader, curUploadDate, curFileType));
        }
        preparedStatement.close();
        connection.close();
        rs.close();
        return fileList;
    } catch (SQLException e) {
        Alert sqlAlert = new Alert(Alert.AlertType.ERROR);
        sqlAlert.setTitle("Error loading files");
        sqlAlert.setHeaderText(null);
        sqlAlert.setContentText("The program encountered an error and couldn't load the files, check your connection and please try again");
        sqlAlert.showAndWait();
        throw new IllegalStateException("Cannot connect the database!", e);
    }
}}

