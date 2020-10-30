public class Dummy{
public void deleteAllItems() {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
        conn = DBHelper.getConnection();
        String sql = "delete from items where id='?'";
        stmt = conn.prepareStatement(sql);
        stmt.setObjec(1,id);
        int falg = stmt.executeUpdate();
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

