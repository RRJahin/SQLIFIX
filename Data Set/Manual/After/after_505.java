public class Dummy{
public static Reservation queryReservation(Connection conn, BigInteger GuestID) throws SQLException {
    String sql = "Select a.Reservation_Id, a.GuestID, a.start, a.end, a.numberRooms, a.bookingDate, a.status, a.reservationType, a.price from Reservations a where a.GuestID = ?";
    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setObject(1, GuestID.toString());
    ResultSet rs = pstm.executeQuery();
    if (rs.next()) {
        BigInteger Reservation_Id = BigInteger.valueOf(rs.getLong("Reservation_Id"));
        LocalDate start = rs.getDate("start").toLocalDate();
        LocalDate end = rs.getDate("end").toLocalDate();
        int numberRooms = rs.getInt("numberRooms");
        LocalDateTime bookingDate = rs.getTimestamp("bookingDate").toLocalDateTime();
        String status = rs.getString("status");
        String reservationType = rs.getString("reservationType");
        Double price = rs.getDouble("price");
        Reservation reservation = new Reservation(Reservation_Id, GuestID, start, end, numberRooms, bookingDate, status, reservationType, price);
        reservation.setPrice(price);
        return reservation;
    }
    return null;
}}

