public class Dummy{
public Book findByName(String bookName) {
    Book book = new Book();
    try {
        String sql = "SELECT id,idAuthor FROM book where name='" + bookName + "'";
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.first()) {
            book.setId(resultSet.getInt("id"));
            book.setName(bookName);
            book.setIdAuthor(resultSet.getInt("idAuthor"));
        }
        resultSet.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return book;
}}

