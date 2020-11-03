public class Dummy{
@Override
public void addGuitar(Guitar guitar) {
    Connection Conn = MySqlDBUtil.open();
    String sql = "insert into Guitar(serialNumber,price,builder,type,backWood,topWood) values(?,?,?,?,?,?)";
    try {
        PreparedStatement pstmt = Conn.prepareStatement(sql);
        pstmt.setObject(1, guitar.getSerialNumber());
        pstmt.setObject(2, guitar.getPrice());
        pstmt.setObject(3, guitar.getSpec().getBuilder());
        pstmt.setObject(4, guitar.getSpec().getType());
        pstmt.setObject(5, guitar.getSpec().getBackWood());
        pstmt.setObject(6, guitar.getSpec().getTopWood());
        pstmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        MySqlDBUtil.close(Conn);
    }
}}

