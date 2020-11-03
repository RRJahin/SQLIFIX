public class Dummy {

  public void update(Book book) {
    try {
      statement =
        connection.createStatement(
          ResultSet.TYPE_SCROLL_INSENSITIVE,
          ResultSet.CONCUR_UPDATABLE
        );
      String sql ="update Book set name = '" +book.getName() +"', idAuthor =" +book.getIdAuthor() +"where id =" +book.getId();
      statement.executeUpdate(sql);
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {}
  }
}
