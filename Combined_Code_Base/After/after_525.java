public class Dummy{
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    id = request.getParameter("id");
    System.out.println("id DPS=" + id);
    String query = "delete from project_hrm where id='?'";
    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "avinash", "tiger");
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setObject(1,id);
        statement.executeQuery();
        connection.close();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}}

