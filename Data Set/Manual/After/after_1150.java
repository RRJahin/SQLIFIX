public class Dummy{
public static void insertReservation(Connection conn, int GuestID, LocalDate start, LocalDate end, int numberRooms) throws SQLException {
    String sql = "Insert into Reservations(GuestID, start, end, numberRooms) values (?, ?, ?, ?)";
    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setObject(1, GuestID);
    pstm.setObject(2, start);
    pstm.setObject(3, end);
    pstm.setObject(4, numberRooms);
    pstm.executeUpdate();
}}

