public class Dummy{
public static ArrayList<String> getTemplateFieldsByActiveAndUserID(String uname, String pwd) throws Exception {
    ArrayList<String> fields = new ArrayList<String>();
    int userID = 1;
    Connection dbConn = null;
    try {
        try {
            dbConn = DBConnection.createConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Statement stmt = dbConn.createStatement();
        String query = "SELECT smartreporter.field.Name, smartreporter.field.Size" + " FROM " + "smartreporter.field, smartreporter.template, smartreporter.user" + " WHERE " + "smartreporter.field.TemplateID=smartreporter.template.ID" + " AND " + "smartreporter.template.ACTIVE=1 " + " AND " + "smartreporter.template.User_ID=" + userID;
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            fields.add(rs.getString("smartreporter.field.Name"));
        }
    } catch (SQLException sqle) {
        throw sqle;
    } catch (Exception e) {
        if (dbConn != null) {
            dbConn.close();
        }
        throw e;
    } finally {
        if (dbConn != null) {
            dbConn.close();
        }
    }
    return fields;
}}

