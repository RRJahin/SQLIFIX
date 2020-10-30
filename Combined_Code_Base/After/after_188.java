public class Dummy {
    public static void insertIntoTamplateTable(Template template) throws Exception {
        try {
            Connection conn = getDatabaseConnection();
            PreparedStatement s = conn.prepareStatement("INSERT INTO template_table VALUES(" + "'?'," + "'?'," + "'?')");
            s.setObject(1, template.getName());
            s.setObject(2, template.getPath());
            s.setObject(3, template.getMd5());
            s.executeUpdate();
            conn.close();
        } catch (Exception e) {
            throw new Exception("Error inserting into template_table.\n" + e.getMessage());
        }
    }
}
