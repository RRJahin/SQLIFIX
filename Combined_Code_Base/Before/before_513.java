public class Dummy{
public static List<Room> selectAvailableRooms(Connection conn, LocalDate startDate, LocalDate endDate) throws SQLException {
    String sql = "SELECT r.Room_Number, r.capacity, r.price FROM sse.Room AS r WHERE r.Room_Number NOT IN(SELECT b.roomNumber FROM sse.Reserved_Rooms AS b JOIN sse.Reservations AS a ON a.Reservation_Id=b.reservationID WHERE a.start >= ? AND a.end <= ? AND a.status='Active')";
    Statement pstm = conn.createStatement(sql);
    pstm.setObject(1, startDate);
    pstm.setObject(2, endDate);
    ResultSet rs = pstm.executeQuery();
    List<Room> list = new ArrayList<Room>();
    while (rs.next()) {
        String roomNumber = rs.getString(1);
        int roomCapacity = rs.getInt(2);
        int roomPrice = rs.getInt(3);
        Room room = new Room(roomNumber);
        room.setCapacity(roomCapacity);
        room.setPrice(roomPrice);
        list.add(room);
    }
    return list;
}}

