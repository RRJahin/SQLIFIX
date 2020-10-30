public class Dummy{
public boolean register(String name, String password) {
    String sql1 = "select name from login where name='" + name + "'";
    String sql = "insert into login(name,password)values('" + name + "','" + password + "')";
    boolean have = false;
    try {
        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery(sql1);
        if (result.next()) {
            have = true;
            JOptionPane.showMessageDialog(null, "���˺��Ѿ�����");
            return false;
        } else {
            stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "ע��ɹ�");
            return true;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        close();
    }
    return false;
}}

