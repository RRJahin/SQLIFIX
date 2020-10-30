public class Dummy{
public static Template getTemplate(String name) throws Exception {
    try {
        Template t = null;
        Connection conn = getDatabaseConnection();
        PreparedStatement s = conn.prepareStatement("SELECT * FROM template_table WHERE name='?'");
        s.setObject(1,name);
        ResultSet rs = s.executeQuery();
        if (rs.next()) {
            t = new Template(rs.getString("name"), rs.getString("path"), rs.getString("md5"));
        }
        conn.close();
        return t;
    } catch (Exception e) {
        throw new Exception("Error reading from template_table.\n" + e.getMessage());
    }
}}

