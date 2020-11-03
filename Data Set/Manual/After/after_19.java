import java.sql.PreparedStatement;

public class Dummy{
private ResultSet fetchTable(String tableName, String stockIndex) throws SQLException {
    PreparedStatement statement = null;
    statement = connection.prepareStatement("SELECT * FROM ? WHERE stock = ?;");
    statement.setObject(1,tableName);
    statement.setObject(2, stockIndex);
    ResultSet resultSet = statement.executeQuery();
    return resultSet;
}}

