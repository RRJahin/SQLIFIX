public class Dummy{
public static void insertReservation(Connection conn, BigInteger reservationID, BigInteger GuestID, LocalDate start, LocalDate end, int numberRooms, String status, String reservationType, Double price) throws SQLException {
    String sql = "Insert into Reservations(reservation_Id, GuestID, start, end, numberRooms, status, reservationType, price) values (?, ?, ?, ?, ?, ?, ?, ?)";
    Statement pstm = conn.createStatement(sql);
    pstm.setString(1, reservationID.toString());
    pstm.setString(2, GuestID.toString());
    pstm.setObject(3, start);
    pstm.setObject(4, end);
    pstm.setInt(5, numberRooms);
    pstm.setString(6, status);
    pstm.setString(7, reservationType);
    pstm.setDouble(8, price);
    pstm.executeUpdate();
}}

