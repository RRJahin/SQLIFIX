class Dummy {
    public void saveTest(Test test) {
        try (Connection connection = ConnectionManagerJDBCImpl.getInstance().getConnection()) {
            try (Statement statement = connection.createStatement()) {
                statement.execute("INSERT INTO test(id, testdate, testdouble, testint) VALUES (" + test.getId() + ", "
                        + test.getTestDate() + ", " + test.getTestDouble() + ", " + test.getTestInt() + ")");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
