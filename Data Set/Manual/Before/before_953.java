public class Dummy{
public void editPatient(PatientBean p, long hcpid) throws DBException {
    String newQuery = "SELECT * FROM course WHERE idcourse != "+oldCourseId+" ORDER BY courname;";
    try (Connection connection = DriverManager.getConnection(url, username, password)) {
        Statement ps = connection.createStatement();
        ResultSet rs = ps.executeQuery(newQuery);
        while (rs.next()) {
            Integer curClassId = rs.getInt(1);
            String curClass = rs.getString(2);
            String curClassFac = rs.getString(3);
            courseList.add(new Courses(curClassId, curClass, curClassFac));
        }
        copyComboBox.getItems().clear();
        copyComboBox.setItems(courseList);
        ps.close();
        connection.close();
        rs.close();
    } catch (SQLException e) {
        Alert sqlAlert = new Alert(Alert.AlertType.ERROR);
        sqlAlert.setTitle("Error loading courses");
        sqlAlert.setHeaderText(null);
        sqlAlert.setContentText("The program encountered an error and couldn't load the courses, check your connection and please try again");
        sqlAlert.showAndWait();
        throw new IllegalStateException("Cannot connect the database!", e);
    }
}}

