public class Dummy{
@Override
public void sessionDestroyed(HttpSessionEvent event) {
    System.out.println("session destroy:" + new Date().toString());
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:9487/brad", "root", "root");
        Statement stmt = conn.createStatement();
        HttpSession session = event.getSession();
        String dbid = (String) session.getAttribute("dbid");
        stmt.executeUpdate("update member set islogin=0 where id=" + dbid);
    } catch (Exception ee) {
        System.out.println(ee.toString());
    }
}}

