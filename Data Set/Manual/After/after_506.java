public class Dummy{
public static Reservation queryReservation(Connection conn, BigInteger GuestID, LocalDate start, LocalDate end, int numberRooms, String status, String reservationType, Double price) throws SQLException {
    String sql = "Select a.Reservation_Id, a.GuestID, a.start, a.end, a.numberRooms, a.bookingDate, a.status, a.reservationType, a.price from Reservations a " 
     + "where a.GuestID = "+GuestID.toString()+" and a.start = "+start+" and a.end = "+end+" and a.numberRooms = "+numberRooms+" and a.status = "+status + " and a.reservationType = "+reservationType+" and a.price = "+price;
    PreparedStatement pstm = conn.prepareStatement(sql);
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

