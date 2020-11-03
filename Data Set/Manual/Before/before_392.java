public class Dummy{
public void addAuthor(Author author) throws SQLException {
    String query = "INSERT INTO tblauthor(author_name, gender, description) VALUES("+author.getAuthorName()+", "+author.getGender()+", "+author.getDescription()+")";
    Statement ps = DbConnect.getConnection().createStatement();
    ps.executeUpdate(query);
}}

