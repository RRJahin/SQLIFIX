public class Dummy{
private void createCDs(Connection connection) throws SQLException {
    final PreparedStatement statement = connection.prepareStatement("INSERT INTO cd (id, title) values (?, ?)");
    for (int id = 1; id <= NUM_CDS; id++) {
        statement.setObject(1, id);
        statement.setObject(2, "title " + id);
        statement.addBatch();
    }
    statement.executeBatch();
}}

