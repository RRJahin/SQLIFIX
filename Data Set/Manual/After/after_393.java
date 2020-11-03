public class Dummy{
public void editAuthor(Author author) throws SQLException {
    String query = "UPDATE tblauthor SET author_name = ?, gender = ?, description = ? WHERE id = " + author.getId();
    PreparedStatement ps = DbConnect.getConnection().prepareStatement(query);
    ps.setObject(1, author.getAuthorName());
    ps.setObject(2, author.getGender());
    ps.setObject(3, author.getDescription());
    ps.executeUpdate();
}}

