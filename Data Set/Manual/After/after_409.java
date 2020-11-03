public class Dummy{
@Override
public Reply update(String jsonString) {
    long postId;
    try (Connection connection = dataSource.getConnection()) {
        JsonObject object = new JsonParser().parse(jsonString).getAsJsonObject();
        postId = object.get("post").getAsLong();
        String message = object.get("message").getAsString();
        String query = new StringBuilder("UPDATE ").append(tableName).append(" SET message = ? WHERE id = ?").toString();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setObject(1, message);
            ps.setObject(2, postId);
            ps.executeUpdate();
        } catch (SQLException e) {
            return new Reply(Status.NOT_FOUND);
        }
    } catch (Exception e) {
        return new Reply(Status.INVALID_REQUEST);
    }
    return new Reply(Status.OK, details(postId, null).getObject());
}}

