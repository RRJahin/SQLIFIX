class Dummy {
    @Override
    public void delGuitar(String SerialNumber) {
        Connection Conn = SqliteDBUtil.open();
        String sql = "delete from Guitar where SerialNumber = " + SerialNumber;
        try {
            Statement pstmt = Conn.createStatement();
            pstmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SqliteDBUtil.close(Conn);
        }
    }
}
