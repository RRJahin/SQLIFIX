public class Dummy{
public static Reservation queryReservationRID(Connection conn, BigInteger Reservation_Id) throws SQLException {
    String sql = "Select a.Reservation_Id, a.GuestID, a.start, a.end, a.duration, a.numberRooms, a.bookingDate, a.status, a.reservationType, a.price from Reservations a WHERE a.Reservation_Id = "+Reservation_Id.toString()+ " and a.reservationType = 'Guest' ";
    Statement pstm = conn.createStatement();
    ResultSet rs = pstm.executeQuery(sql);
    if (rs.next()) {
        BigInteger GuestID = BigInteger.valueOf(rs.getLong("GuestID"));
        LocalDate start = rs.getDate("start").toLocalDate();
        LocalDate end = rs.getDate("end").toLocalDate();
        int numberRooms = rs.getInt("numberRooms");
        LocalDateTime bookingDate = rs.getTimestamp("bookingDate").toLocalDateTime();
        String status = rs.getString("status");
        String reservationType = rs.getString("reservationType");
        double price = rs.getDouble("price");
        Reservation reservation = new Reservation(Reservation_Id, GuestID, start, end, numberRooms, bookingDate, status, reservationType, price);
        return reservation;
    }
    return null;
}}

