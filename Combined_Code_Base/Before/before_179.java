public class Dummy {
    @Override
    public void addGuitar(Guitar guitar) {
        Connection Conn = MySqlDBUtil.open();
        String sql = "insert into Guitar(serialNumber,price,builder,type,backWood,topWood) values("
                + guitar.getSerialNumber() + "," + guitar.getPrice() + "," + guitar.getSpec().getBuilder() + ","
                + guitar.getSpec().getType() + "," + guitar.getSpec().getBackWood() + ","
                + guitar.getSpec().getTopWood() + ")";
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
