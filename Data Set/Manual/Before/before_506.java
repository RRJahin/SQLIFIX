public class Dummy{
public static Reservation queryReservation(Connection conn, BigInteger GuestID, LocalDate start, LocalDate end, int numberRooms, String status, String reservationType, Double price) throws SQLException {
    String sql = "Select a.Reservation_Id, a.GuestID, a.start, a.end, a.numberRooms, a.bookingDate, a.status, a.reservationType, a.price from Reservations a " + "where a.GuestID = ? and a.start = ? and a.end = ? and a.numberRooms = ? and a.status = ?" + "and a.reservationType = ? and a.price = ?";
    Statement pstm = conn.createStatement(sql);
    pstm.setString(1, GuestID.toString());
    pstm.setObject(2, start);
    pstm.setObject(3, end);
    pstm.setInt(4, numberRooms);
    pstm.setString(5, status);
    pstm.setString(6, reservationType);
    pstm.setDouble(7, price);
    ResultSet rs = pstm.executeQuery();
    if (rs.next()) {
        BigInteger Reservation_Id = BigInteger.valueOf(rs.getLong("Reservation_Id"));
        LocalDateTime bookingDate = rs.getTimestamp("bookingDate").toLocalDateTime();
        Reservation reservation = new Reservation(Reservation_Id, GuestID, start, end, numberRooms, bookingDate, status, reservationType, price);
        reservation.setPrice(price);
        return reservation;
    }
    return null;
}}

