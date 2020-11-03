public class Dummy{
private void createBooks(Connection connection) throws SQLException {
    final Statement statement = connection.createStatement("INSERT INTO book (id, title) values (?, ?)");
    for (int id = 1; id <= NUM_BOOKS; id++) {
        statement.setInt(1, id);
        statement.setString(2, "title " + id);
        statement.addBatch();
    }
    statement.executeBatch();
}}

