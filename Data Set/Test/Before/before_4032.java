class Dummy {
    @Override
    public Student getStudentById(int studentId) {
        Student student = new Student();
        try (Connection conn = DBConnectionUtility.getDBConnection()) {
            String query = "select * from student where studentId=" + studentId;
            Statement preparedStatement = conn.createStatement();
            ResultSet resultSet = preparedStatement.executeQuery(query);
            while (resultSet.next()) {
                student.setStudentId(resultSet.getInt("studentId"));
                student.setFirstName(resultSet.getString("firstName"));
                student.setLastName(resultSet.getString("LastName"));
                student.setCourse(resultSet.getString("course"));
                student.setYear(resultSet.getInt("year"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }
}
