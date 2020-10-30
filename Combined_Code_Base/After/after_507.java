public class Dummy{
public static List<Reservation> queryReservations(Connection conn, BigInteger GuestID, String reservationType) throws SQLException {
    String sql = "Select a.Reservation_Id, a.GuestID, a.start, a.end, a.numberRooms, a.bookingDate, a.status, a.reservationType, a.price from Reservations a where a.GuestID =  "+GuestID.toString()+" and a.reservationType = "+reservationType+" ";
    List<Reservation> reservations = new ArrayList<>();
    PreparedStatement pstm = conn.prepareStatement();
    ResultSet rs = pstm.executeQuery(sql);
    while (rs.next()) {
        BigInteger Reservation_Id = BigInteger.valueOf(rs.getLong("Reservation_Id"));
        LocalDate start = rs.getDate("start").toLocalDate();
        LocalDate end = rs.getDate("end").toLocalDate();
        int numberRooms = rs.getInt("numberRooms");
        LocalDateTime bookingDate = rs.getTimestamp("bookingDate").toLocalDateTime();
        String status = rs.getString("status");
        Double price = rs.getDouble("price");
        Reservation reservation = new Reservation(Reservation_Id, GuestID, start, end, numberRooms, bookingDate, status, reservationType, price);
        reservation.setPrice(price);
        reservations.add(reservation);
    }
    return reservations;
}}

