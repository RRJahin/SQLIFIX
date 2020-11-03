class Dummy {
    @Override
    public void updateStudent(Student student) {
        try (Connection conn = DBConnectionUtility.getDBConnection()) {
            String query = "update student set firstName=" + student.getFirstName() + ", lastName="
                    + student.getLastName() + ", year=" + student.getYear() + " where studentId="
                    + student.getStudentId();
            Statement preparedStatement = conn.createStatement();
            preparedStatement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
