public class Dummy{
@Override
public Reply details(long postId, String[] related) {
    Post post;
    try (Connection connection = dataSource.getConnection()) {
        String query = new StringBuilder("SELECT * FROM ").append(tableName).append(" WHERE id = ?").toString();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setObject(1, postId);
            try (ResultSet resultSet = ps.executeQuery()) {
                resultSet.next();
                post = new Post(resultSet);
            }
        } catch (SQLException e) {
            return new Reply(Status.NOT_FOUND);
        }
        if (related != null) {
            if (Arrays.asList(related).contains("forum")) {
                post.setForum(new ForumDAOImpl(dataSource).details(post.getForum().toString(), null).getObject());
            }
            if (Arrays.asList(related).contains("thread")) {
                long threadId = Long.parseLong(post.getThread().toString());
                post.setThread(new ThreadDAOImpl(dataSource).details(threadId, null).getObject());
            }
            if (Arrays.asList(related).contains("user")) {
                post.setUser(new UserDAOImpl(dataSource).details(post.getUser().toString()).getObject());
            }
        }
    } catch (Exception e) {
        return new Reply(Status.INVALID_REQUEST);
    }
    return new Reply(Status.OK, post);
}}

