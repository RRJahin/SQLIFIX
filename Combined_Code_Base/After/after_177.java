public class Dummy {

  public void update(Book book) {
    try {
      String sql = "update Book set name = '?', idAuthor =?where id =?";
      statement =
        connection.prepareStatement(
          sql,
          ResultSet.TYPE_SCROLL_INSENSITIVE,
          ResultSet.CONCUR_UPDATABLE
        );
      statement.setObject(1, book.getName());
      statement.setObject(2, book.getIdAuthor());
      statement.setObject(3, book.getId());
      statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {}
  }
}
