public class Dummy{
public Author getAuthorByName(String name) throws SQLException {
    Author author = null;
    String sql = "SELECT * FROM tblauthor WHERE author_name = '?'";
    PreparedStatement ps = DbConnect.getConnection().prepareStatement(sql);
    ps.setObject(1,name);
    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
        int id = rs.getInt("id");
        String gender = rs.getString("gender");
        String description = rs.getString("description");
        author = new Author(id, name, gender, description);
    }
    return author;
}}

