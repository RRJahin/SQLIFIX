public class Dummy{
public static void insertReservation(Connection conn, BigInteger reservationID, BigInteger GuestID, LocalDate start, LocalDate end, int numberRooms, String status, String reservationType, Double price) throws SQLException {
    String sql = "Insert into Reservations(reservation_Id, GuestID, start, end, numberRooms, status, reservationType, price) values (?, ?, ?, ?, ?, ?, ?, ?))";
    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setObject(1,reservationID.toString());
    pstm.setObject(2,GuestID.toString());
    pstm.setObject(3,start);
    pstm.setObject(4,end);
    pstm.setObject(5,numberRooms);
    pstm.setObject(6,status);
    pstm.setObject(7,reservationType);
    pstm.setObject(8,price);
    pstm.executeUpdate();
}}

