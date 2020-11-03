class Dummy {
    @Override
    public void addStudent(Student student) {
        try (Connection conn = DBConnectionUtility.getDBConnection()) {
            String query = "insert into student (firstName, lastName, course) values (" + student.getFirstName() + ","
                    + student.getLastName() + "," + student.getCourse() + ")";
            Statement preparedStatement = conn.createStatement();
            preparedStatement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
