public class Dummy{
public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");
    String cusId = request.getParameter("CUSID");
    String driId = request.getParameter("DRIID");
    PrintWriter out = response.getWriter();
    Statement statement = null;
    Connection con = null;
    ResultSet result = null;
    String dbUrl = "jdbc:mysql://localhost/TecTalk";
    String sql = "";
    if (cusId != null) {
        sql = "delete from GCMCUS where cus_id = '";
        sql += cusId + "';";
    }
    if (driId != null) {
        sql = "delete from GCMDRI where dri_id = '";
        sql += driId + "';";
    }
    try {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(dbUrl, "root", "tlszps13");
        statement = con.createStatement();
        statement.executeUpdate(sql);
        statement.close();
        con.close();
        out.println("success");
    } catch (SQLException e) {
        out.println("sql error : " + e);
    } catch (Exception e) {
        out.println("error : " + e);
    }
}}

