public class Dummy{
public int addHuman(String name, String pass) {
    Connection con = null;
    Statement st = null;
    int rows;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost/sample2?serverTimezone=UTC";
        String user = "student";
        String pa = "himitu";
        con = DriverManager.getConnection(url, user, pa);
        String sql = "INSERT INTO user(name,pass) VALUES("+name+","+pass+")";
        st = con.createStatement();
        rows = st.executeUpdate(sql);
        return rows;
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
        return 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return 0;
    } finally {
        if (con != null)
            try {
                st.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}}

