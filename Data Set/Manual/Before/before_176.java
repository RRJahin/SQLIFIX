public class Dummy{
public void delete(Book book) {
    try {
        String sql = "delete FROM book where id = " + book.getId() + " and name= '" + book.getName() + "'";
        System.out.println(sql);
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        System.out.println(statement.executeUpdate(sql));
    } catch (SQLException e) {
        e.printStackTrace();
    }
}}

