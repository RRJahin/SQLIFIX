public class Dummy {
    public Book findByName(String bookName) {
        Book book = new Book();
        try {
            String sql = "SELECT id,idAuthor FROM book where name='?'";
            statement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement.setObject(1, bookName);
            ResultSet resultSet = statement.executeQuery();
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
    }
}
