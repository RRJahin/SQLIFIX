public class Dummy{
public Author getAuthorByName(String name) throws SQLException {
    Author author = null;
    String sql = "SELECT * FROM tblauthor WHERE author_name = '" + name + "'";
    Statement ps = DbConnect.getConnection().createStatement();
    ResultSet rs = ps.executeQuery(sql);
    while (rs.next()) {
        int id = rs.getInt("id");
        String gender = rs.getString("gender");
        String description = rs.getString("description");
        author = new Author(id, name, gender, description);
    }
    return author;
}}

