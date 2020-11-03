class Dummy{
public static void deleteAlert(HttpServletResponse response, Connection dbCon, int id) {
    String query = "DELETE FROM alerts WHERE id = "+id+";";
    try {
        Statement removeAlert = dbCon.createStatement();
        removeAlert.executeUpdate(query);
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

