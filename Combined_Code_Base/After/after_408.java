public class Dummy{
@Override
public Reply restore(String jsonString) {
    try (Connection connection = dataSource.getConnection()) {
        Long postId = new JsonParser().parse(jsonString).getAsJsonObject().get("post").getAsLong();
        String query = new StringBuilder("UPDATE ").append(tableName).append(" SET isDeleted = 0 WHERE id = ?").toString();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setObject(1, postId);
            ps.executeUpdate();
        } catch (SQLException e) {
            new Reply(Status.NOT_FOUND);
        }
        Post post;
        query = new StringBuilder("SELECT * FROM ").append(tableName).append(" WHERE id = ?").toString();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setObject(1, postId);
            try (ResultSet resultSet = ps.executeQuery()) {
                resultSet.next();
                post = new Post(resultSet);
            }
        } catch (SQLException e) {
            return new Reply(Status.NOT_FOUND);
        }
        query = "UPDATE Thread SET posts = posts + 1 WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setObject(1, Long.parseLong(post.getThread().toString()));
            ps.executeUpdate();
        } catch (SQLException e) {
            return new Reply(Status.NOT_FOUND);
        }
    } catch (Exception e) {
        return new Reply(Status.INVALID_REQUEST);
    }
    return new Reply(Status.OK, new Gson().fromJson(jsonString, Object.class));
}}

