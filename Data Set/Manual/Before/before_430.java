public class Dummy{
private void createCDs(Connection connection) throws SQLException {
    final Statement statement = connection.createStatement("INSERT INTO cd (id, title) values (?, ?)");
    for (int id = 1; id <= NUM_CDS; id++) {
        statement.setInt(1, id);
        statement.setString(2, "title " + id);
        statement.addBatch();
    }
    statement.executeBatch();
}}

