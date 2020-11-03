public class Dummy{
@Override
public Reply vote(String jsonString) {
    long postId;
    try (Connection connection = dataSource.getConnection()) {
        JsonObject object = new JsonParser().parse(jsonString).getAsJsonObject();
        int vote = object.get("vote").getAsInt();
        postId = object.get("post").getAsLong();
        final String column = vote == -1 ? "dislikes" : "likes";
        String query = new StringBuilder("UPDATE ").append(tableName).append(" SET ").append(column).append(" = ").append(column).append(" + 1, points = points + ").append(Integer.toString(vote)).append(" WHERE id = "+postId).toString();
        try (Statement ps = connection.createStatement()) {
            ps.executeUpdate(query);
        } catch (SQLException e) {
            return new Reply(Status.NOT_FOUND);
        }
    } catch (Exception e) {
        return new Reply(Status.INVALID_REQUEST);
    }
    return details(postId, null);
}}

