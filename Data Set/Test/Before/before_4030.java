class Dummy {
    @Override
    public void deleteStudent(int studentId) {
        try (Connection conn = DBConnectionUtility.getDBConnection()) {
            String query = "delete from student where studentId=" + studentId;
            Statement preparedStatement = conn.createStatement();
            preparedStatement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
