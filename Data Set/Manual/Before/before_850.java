public class Dummy {
    @Override
    public void delGuitar(String SerialNumber) {
        Connection Conn = MySqlDBUtil.open();
        String sql = "delete from guitar where SerialNumber = " + SerialNumber;
        try {
            Statement pstmt = Conn.createStatement();
            pstmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlDBUtil.close(Conn);
        }
    }
}
