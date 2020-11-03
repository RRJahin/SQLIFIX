public class Dummy{
public void loadData() {
    String newQuery = "SELECT DISTINCT course.idcourse, courname, faculty FROM course, instrcourdoc " + "WHERE idinstructor = "+instrId+" AND course.idcourse = instrcourdoc.idcourse ORDER BY courname";
    try (Connection connection = DriverManager.getConnection(url, username, password)) {
        List<Courses> values = new ArrayList<>();
        courseList.clear();
        Statement preparedStatement = connection.createStatement();
        ResultSet rs = preparedStatement.executeQuery(newQuery);
        while (rs.next()) {
            Integer curClassId = rs.getInt(1);
            String curClassName = rs.getString(2);
            String curClassFac = rs.getString(3);
            courseList.add(new Courses(curClassId, curClassName, curClassFac));
        }
        preparedStatement.close();
        connection.close();
        rs.close();
        classes.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        classes.setItems(courseList);
    } catch (SQLException e) {
        Alert sqlAlert = new Alert(Alert.AlertType.ERROR);
        sqlAlert.setTitle("Error loading courses");
        sqlAlert.setHeaderText(null);
        sqlAlert.setContentText("The program encountered an error and couldn't load the courses, check your connection and restart program");
        sqlAlert.showAndWait();
        throw new IllegalStateException("Cannot connect the database!", e);
    }
}}

