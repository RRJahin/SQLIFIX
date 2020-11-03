public class Dummy{
public static void updateReservationStatus(Connection conn, BigInteger reservationID) throws SQLException {
    String sql = "Update Reservations set status =? where Reservation_Id=? ";
    Statement pstm = conn.createStatement(sql);
    pstm.setString(1, "Cancelled");
    pstm.setString(2, reservationID.toString());
    pstm.executeUpdate();
}}

