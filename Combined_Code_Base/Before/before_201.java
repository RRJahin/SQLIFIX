public class Dummy{
public static Template getTemplate(String name) throws Exception {
    try {
        Template t = null;
        Connection conn = getDatabaseConnection();
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM template_table WHERE name='" + name + "'");
        if (rs.next()) {
            t = new Template(rs.getString("name"), rs.getString("path"), rs.getString("md5"));
        }
        conn.close();
        return t;
    } catch (Exception e) {
        throw new Exception("Error reading from template_table.\n" + e.getMessage());
    }
}}

