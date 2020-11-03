public class Dummy{
public Author getAuthorById(int id) throws SQLException {
    Author author = null;
    String sql = "SELECT * FROM tblauthor WHERE id = "+id;
    Statement ps = DbConnect.getConnection().createStatement();
    ResultSet rs = ps.executeQuery(sql);
    while (rs.next()) {
        String name = rs.getString("author_name");
        String gender = rs.getString("gender");
        String description = rs.getString("description");
        author = new Author(id, name, gender, description);
    }
    return author;
}}

