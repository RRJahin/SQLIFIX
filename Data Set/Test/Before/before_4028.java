class Dummy {
    public Student update(Student stu2) {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Error creating connection to database: " + e);
            System.exit(-1);
        }
        String query = "Update Gaurav_Student set student_name=" + stu2.getStudent_name() + ",userid = "
                + stu2.getStudent_id() + " where student_id=" + stu2.getUserid();
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                stu2.setStudent_id((resultSet.getInt(1)));
            }
        } catch (SQLException e) {
            stu2 = null;
            System.out.println("Error Creating Bank: " + e);
        }
        try {
            connection.close();
            connection = null;
        } catch (SQLException e) {
            System.out.println("Error closing connection: " + e);
        }
        return stu2;
    }
}
