public class Dummy {
public Book findById(int idBook) {
    Book book = new Book();
    book.setId(0);
    try {
        String sql = "SELECT id,name,idAuthor FROM book where id=?";
        statement = connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        statement.setObject(1,idBook);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.first()) {
            book.setId(resultSet.getInt("id"));
            book.setName(resultSet.getString("name"));
            book.setIdAuthor(resultSet.getInt("idAuthor"));
        }
        resultSet.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    r
