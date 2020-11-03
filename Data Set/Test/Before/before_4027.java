class Dummy {
    public Student delete(Student stu1) {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Error creating connection to database: " + e);
            System.exit(-1);
        }
        String query = "DELETE FROM Gaurav_Student WHERE userid=" + stu1.getUserid1();
        String query1 = "Delete from Gaurav_Login where userid = " + stu1.getUserid1();
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                stu1.setStudent_id(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            stu1 = null;
            System.out.println("Error Creating Student: " + e);
        }
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query1);
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                stu1.setStudent_id(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            stu1 = null;
            System.out.println("Error Creating Bank: " + e);
        }
        try {
            connection.close();
            connection = null;
        } catch (SQLException e) {
            System.out.println("Error closing connection: " + e);
        }
        return stu1;
    }
}
