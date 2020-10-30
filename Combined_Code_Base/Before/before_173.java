public class Dummy{
public void save(Book book) {
    if (findByName(book.getName()).getName() == null) {
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            int id = getNextId();
            book.setId(id);
            String sql = "insert into book values (" + id + ", '" + book.getName() + "', " + book.getIdAuthor() + ")";
            System.out.println(sql);
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}}

