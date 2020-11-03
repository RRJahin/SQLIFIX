public class Dummy{
private void loadInstructors() {
    instructorTableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    String loadInstrQuery = "SELECT * FROM instructor WHERE idinstructor != "+instrId+" ORDER BY lname";
    try (Connection connection = DriverManager.getConnection(url, username, password)) {
        Statement ps = connection.createStatement();
        ResultSet rs = ps.executeQuery(loadInstrQuery);
        while (rs.next()) {
            int curInstrId = rs.getInt(1);
            String fname = rs.getString(2);
            String lname = rs.getString(3);
            String faculty = rs.getString(4);
            String email = rs.getString(5);
            String password = rs.getString(6);
            int admin = rs.getInt(7);
            instructorList.add(new Instructor(curInstrId, fname, lname, faculty, email, password, admin));
        }
        ps.close();
        rs.close();
        connection.close();
        instructorTableView.setItems(instructorList);
    } catch (SQLException e) {
        Alert sqlAlert = new Alert(Alert.AlertType.ERROR);
        sqlAlert.setTitle("Error loading instructors");
        sqlAlert.setHeaderText(null);
        sqlAlert.setContentText("The program encountered an error and couldn't load the instructors, check your connection and please try again");
        sqlAlert.showAndWait();
        throw new IllegalStateException("Cannot connect the database!", e);
    }
}}

