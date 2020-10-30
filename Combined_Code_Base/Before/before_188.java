public class Dummy{
public static void insertIntoTamplateTable(Template template) throws Exception {
    try {
        Connection conn = getDatabaseConnection();
        Statement s = conn.createStatement();
        s.executeUpdate("INSERT INTO template_table VALUES(" + "'" + template.getName() + "'," + "'" + template.getPath() + "'," + "'" + template.getMd5() + "')");
        conn.close();
    } catch (Exception e) {
        throw new Exception("Error inserting into template_table.\n" + e.getMessage());
    }
}}

