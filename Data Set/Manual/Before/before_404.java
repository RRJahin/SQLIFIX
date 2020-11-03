public class Dummy{
@Override
public Reply create(String jsonString) {
    final Post post;
    try (Connection connection = dataSource.getConnection()) {
        post = new Post(new JsonParser().parse(jsonString).getAsJsonObject());
        String parentPatch = "";
        if (post.getParent() != null) {
            String query = new StringBuilder("SELECT patch FROM ").append(tableName).append(" WHERE id = "+post.getParent()).toString();
            try (Statement ps = connection.createStatement()) {
                try (ResultSet resultSet = ps.executeQuery(query)) {
                    resultSet.next();
                    parentPatch = resultSet.getString("patch");
                }
            }
        }
        StringBuilder buildedQuery = new StringBuilder("SELECT MAX(patch) AS Max_patch FROM ").append(tableName).append(" WHERE thread = "+Long.parseLong(post.getThread().toString())+" AND patch LIKE '");
        if (!parentPatch.equals("")) {
            buildedQuery.append(parentPatch);
        }
        buildedQuery.append("____'");
        String maxPatch = null;
        try (Statement ps = connection.createStatement()) {
            try (ResultSet resultSet = ps.executeQuery(buildedQuery.toString())) {
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
        String query = new StringBuilder("INSERT INTO ").append(tableName).append("(date, forum, isApproved, isDeleted, isEdited, isHighlighted, isSpam, message, parent, thread, user, patch)").append(" VALUES ("+post.getDate()+", "+post.getForum().toString()+", "+post.getIsApproved()+", "+post.getIsDeleted()+", "+post.getIsEdited()+", "+post.getIsHighlighted()+", "+post.getIsSpam()+", "+post.getMessage()+", "+post.getParent()+", "+Long.parseLong(post.getThread().toString())+", "+post.getUser().toString()+", "+resultPatch+")").toString();
        try (Statement ps = connection.createStatement( Statement.RETURN_GENERATED_KEYS)) {
            ps.executeUpdate(query);
            try (ResultSet resultSet = ps.getGeneratedKeys()) {
                resultSet.next();
                post.setId(resultSet.getLong(1));
                post.setPatch(resultPatch);
            }
        } catch (SQLException e) {
            return handeSQLException(e);
        }
        query = "UPDATE Thread SET posts = posts + 1 WHERE id = "+Long.parseLong(post.getThread().toString());
        try (Statement ps = connection.createStatement()) {
            ps.executeUpdate(query);
        } catch (SQLException e) {
            return new Reply(Status.NOT_FOUND);
        }
        query = "INSERT INTO UsersOfForum(forum, email) VALUES ("+post.getForum().toString()+", "+post.getUser().toString()+")";
        try (Statement ps = connection.createStatement()) {
            ps.executeUpdate(query);
        } catch (SQLException e) {
        }
    } catch (Exception e) {
        return new Reply(Status.INVALID_REQUEST);
    }
    return new Reply(Status.OK, post);
}}

