public class Dummy{
@Override
public Reply create(String jsonString) {
    final Post post;
    try (Connection connection = dataSource.getConnection()) {
        post = new Post(new JsonParser().parse(jsonString).getAsJsonObject());
        String parentPatch = "";
        if (post.getParent() != null) {
            String query = new StringBuilder("SELECT patch FROM ").append(tableName).append(" WHERE id = ?").toString();
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setObject(1, post.getParent());
                try (ResultSet resultSet = ps.executeQuery()) {
                    resultSet.next();
                    parentPatch = resultSet.getString("patch");
                }
            }
        }
        StringBuilder buildedQuery = new StringBuilder("SELECT MAX(patch) AS Max_patch FROM ").append(tableName).append(" WHERE thread = ? AND patch LIKE '");
        if (!parentPatch.equals("")) {
            buildedQuery.append(parentPatch);
        }
        buildedQuery.append("____'");
        String maxPatch = null;
        try (PreparedStatement ps = connection.prepareStatement(buildedQuery.toString())) {
            ps.setObject(1, Long.parseLong(post.getThread().toString()));
            try (ResultSet resultSet = ps.executeQuery()) {
                resultSet.next();
                maxPatch = resultSet.getString("Max_patch");
            }
        }
        String resultPatch;
        if (maxPatch != null) {
            resultPatch = incPatch(maxPatch);
        } else {
            resultPatch = parentPatch + "0001";
        }
        String query = new StringBuilder("INSERT INTO ").append(tableName).append("(date, forum, isApproved, isDeleted, isEdited, isHighlighted, isSpam, message, parent, thread, user, patch)").append(" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)").toString();
        try (PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            ps.setObject(1, post.getDate());
            ps.setObject(2, post.getForum().toString());
            ps.setBoolean(3, post.getIsApproved());
            ps.setBoolean(4, post.getIsDeleted());
            ps.setBoolean(5, post.getIsEdited());
            ps.setBoolean(6, post.getIsHighlighted());
            ps.setBoolean(7, post.getIsSpam());
            ps.setObject(8, post.getMessage());
            ps.setObject(9, post.getParent());
            ps.setObject(10, Long.parseLong(post.getThread().toString()));
            ps.setObject(11, post.getUser().toString());
            ps.setObject(12, resultPatch);
            ps.executeUpdate();
            try (ResultSet resultSet = ps.getGeneratedKeys()) {
                resultSet.next();
                post.setId(resultSet.getLong(1));
                post.setPatch(resultPatch);
            }
        } catch (SQLException e) {
            return handeSQLException(e);
        }
        query = "UPDATE Thread SET posts = posts + 1 WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setObject(1, Long.parseLong(post.getThread().toString()));
            ps.executeUpdate();
        } catch (SQLException e) {
            return new Reply(Status.NOT_FOUND);
        }
        query = "INSERT INTO UsersOfForum(forum, email) VALUES (?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setObject(1, post.getForum().toString());
            ps.setObject(2, post.getUser().toString());
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    } catch (Exception e) {
        return new Reply(Status.INVALID_REQUEST);
    }
    return new Reply(Status.OK, post);
}}

