class Dummy{
public static void deleteAlert(HttpServletResponse response, Connection dbCon, int id) {
    String query = "DELETE FROM alerts WHERE id = ?;";
    try {
        PreparedStatement removeAlert = dbCon.prepareStatement(query);
        removeAlert.setObject(1, id);
        removeAlert.executeUpdate();
        dbCon.close();
    } catch (SQLException ex) {
        PrintWriter out;
        try {
            out = new PrintWriter(response.getOutputStream());
            response.setContentType("text/html");
            out.print("Couldn't get data:" + ex);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}}

