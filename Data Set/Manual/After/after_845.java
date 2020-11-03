public class Dummy {
public void delete(Book book) {
    try {
        String sql = "delete FROM book where id = ? and name= '?'";
        System.out.println(sql);
        statement = connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        statement.setObject(1,book.getId());
        statement.setObject(2,book.getName());
        System.out.println(statement.executeUpdate());
    } catch (SQLException e) {
        e.printStackTrace();
    }
}}



