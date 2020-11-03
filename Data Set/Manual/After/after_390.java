public class Dummy{
public Author getAuthorById(int id) throws SQLException {
    Author author = null;
    String sql = "SELECT * FROM tblauthor WHERE id = ?";
    PreparedStatement ps = DbConnect.getConnection().prepareStatement(sql);
    ps.setObject(1, id);
    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
        String name = rs.getString("author_name");
        String gender = rs.getString("gender");
        String description = rs.getString("description");
        author = new Author(id, name, gender, description);
    }
    return author;
}}

