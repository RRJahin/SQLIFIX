public class Dummy{
public boolean register(String name, String password) {
    String sql1 = "select name from login where name='?'";
    String sql = "insert into login(name,password)values('?','?')";
    boolean have = false;
    try {
        PreparedStatement stmt = conn.prepareStatement(sql1);
        stmt.setObject(1,name);
        ResultSet result = stmt.executeQuery();
        if (result.next()) {
            have = true;
            JOptionPane.showMessageDialog(null, "���˺��Ѿ�����");
            return false;
        } else {
            stmt = stmt.executeUpdate(sql);
            stmt.setObject(1,name);
            stmt.setObject(2,password);
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

