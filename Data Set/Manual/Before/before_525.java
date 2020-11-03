public class Dummy{
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    id = request.getParameter("id");
    System.out.println("id DPS=" + id);
    String query = "delete from project_hrm where id='" + id + "'";
    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "avinash", "tiger");
        Statement statement = connection.createStatement();
        statement.executeQuery(query);
        connection.close();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}}

