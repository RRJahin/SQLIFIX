public class Dummy{
public static Double selectRoomPrice(Connection conn, String roomNumber) throws SQLException {
    String sql = "SELECT Room_Number, price FROM Room WHERE Room_Number = ?";
    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setObject(1, roomNumber);
    ResultSet rs = pstm.executeQuery();
    if (rs.next()) {
        Double price = rs.getDouble(2);
        Room room = new Room(roomNumber);
        room.setPrice(price);
        return room.getPrice();
    }
    return null;
}}

