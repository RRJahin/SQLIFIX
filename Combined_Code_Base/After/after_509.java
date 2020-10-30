public class Dummy{
public static void updateReservationStatus(Connection conn, BigInteger reservationID) throws SQLException {
    String sql = "Update Reservations set status = \"Cancelled\" where Reservation_Id=? ";
    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setObject(1,reservationID.toString());

    pstm.executeUpdate();
}}

