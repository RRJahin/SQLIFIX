public class Dummy{
public void addAuthor(Author author) throws SQLException {
    String query = "INSERT INTO tblauthor(author_name, gender, description) VALUES(?, ?, ?)";
    PreparedStatement ps = DbConnect.getConnection().prepareStatement(query);
    ps.setObject(1, author.getAuthorName());
    ps.setObject(2, author.getGender());
    ps.setObject(3, author.getDescription());
    ps.executeUpdate();
}}

