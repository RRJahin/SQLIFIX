class Dummy {
    public Student create(Student stu) {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Error creating connection to database: " + e);
            System.exit(-1);
        }
        String query = "INSERT INTO Gaurav_Student (student_id,student_name,userid) VALUES (" + stu.getStudent_id()
                + ", " + stu.getStudent_name() + "," + stu.getUserid() + ") ;";
        try (Statement statement = connection.createStatement()) {
            System.out.println(stu.getUserid());
            statement.executeUpdate(query);
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
            }
        } catch (SQLException e) {
            stu = null;
            System.out.println("Error Creating Student: " + e);
        }
        try {
            connection.close();
            connection = null;
        } catch (SQLException e) {
            System.out.println("Error closing connection: " + e);
        }
        return stu;
    }
}
