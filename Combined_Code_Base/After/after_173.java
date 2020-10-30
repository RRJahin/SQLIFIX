public class Dummy {
    public void save(Book book) {
        if (findByName(book.getName()).getName() == null) {
            try {

                int id = getNextId();
                book.setId(id);
                String sql = "insert into book values (?, '?', ?)";
                statement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                statement.setObject(1, id);
                statement.setObject(2, book.getName());
                statement.setObject(3, book.getIdAuthor());
                System.out.println(sql);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
