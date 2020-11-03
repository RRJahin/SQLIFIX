public class Dummy{
public void editAuthor(Author author) throws SQLException {
    String query = "UPDATE tblauthor SET author_name = "+author.getAuthorName()+", gender = "+author.getGender()+", description = "+author.getDescription()+" WHERE id = " + author.getId();
    Statement ps = DbConnect.getConnection().createStatement();
    ps.executeUpdate(query);
}}

