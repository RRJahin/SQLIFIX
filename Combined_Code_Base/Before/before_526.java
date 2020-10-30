public class Dummy{
public void deleteAllItems() {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    try {
        conn = DBHelper.getConnection();
        String sql = "delete from items where id='" + ID + "'";
        stmt = conn.createStatement();
        int falg = stmt.executeUpdate(sql);
        if (falg > 0) {
            System.out.println("ɾ��ѽ���ɹ�");
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    } finally {
        if (rs != null) {
            try {
                rs.close();
                rs = null;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
                stmt = null;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}}

