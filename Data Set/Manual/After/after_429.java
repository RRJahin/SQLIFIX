public class Dummy{
private void createBooks(Connection connection) throws SQLException {
    final PreparedStatement statement = connection.prepareStatement("INSERT INTO book (id, title) values (?, ?)");
    for (int id = 1; id <= NUM_BOOKS; id++) {
        statement.setObject(1, id);
        statement.setObject(2, "title " + id);
        statement.addBatch();
    }
    statement.executeBatch();
}}

