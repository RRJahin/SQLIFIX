public class Dummy{
public static List<Room> getReservedRooms(Connection conn, BigInteger reservationId) throws SQLException {
    List<Room> rooms = new ArrayList<>();
    String sql = "Select *  from Reserved_Rooms a where a.reservationID = ? ";
    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setObject(1, reservationId.toString());
    ResultSet rs = pstm.executeQuery();
    while (rs.next()) {
        Room r = new Room(rs.getString("roomNumber"));
        r.setReservationNumber(reservationId);
        r.setId(rs.getInt("id"));
        rooms.add(r);
    }
    return rooms;
}}

