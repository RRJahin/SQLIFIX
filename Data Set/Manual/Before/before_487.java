public class Dummy{
public static List<Room> getReservedRooms(Connection conn, BigInteger reservationId) throws SQLException {
    List<Room> rooms = new ArrayList<>();
    String sql = "Select *  from Reserved_Rooms a where a.reservationID = "+reservationId.toString();
    Statement pstm = conn.createStatement();
    ResultSet rs = pstm.executeQuery(sql);
    while (rs.next()) {
        Room r = new Room(rs.getString("roomNumber"));
        r.setReservationNumber(reservationId);
        r.setId(rs.getInt("id"));
        rooms.add(r);
    }
    return rooms;
}}

