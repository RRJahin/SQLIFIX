public class Dummy{
public static void insertReservation(Connection conn, int GuestID, LocalDate start, LocalDate end, int numberRooms) throws SQLException {
    String sql = "Insert into Reservations(GuestID, start, end, numberRooms) values ("+GuestID+", "+start+", "+end+", "+numberRooms+")";
    Statement pstm = conn.createStatement();
    pstm.executeUpdate(sql);
}}

