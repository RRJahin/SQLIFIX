public class Dummy{
public static void deleteBookings(Connection conn, BigInteger reservationID) throws SQLException {
    reservationID.toString();
    String sql = "Delete From Reserved_Rooms where reservationID= ?";
    Statement pstm = conn.createStatement(sql);
    pstm.setString(1, reservationID.toString());
    pstm.executeUpdate();
}}

