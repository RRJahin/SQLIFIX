public class Dummy{
public static List<Room> selectBookedRooms(Connection conn, BigInteger reservationID) throws SQLException {
    String sql = "SELECT roomNumber, reservationID FROM Reserved_Rooms WHERE reservationID = ?";
    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setObject(1, reservationID.toString());
    ResultSet rs = pstm.executeQuery();
    List<Room> list = new ArrayList<Room>();
    while (rs.next()) {
        String roomNumber = rs.getString(1);
        Room room = new Room(roomNumber);
        list.add(room);
    }
    return list;
}}

