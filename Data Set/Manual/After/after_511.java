public class Dummy{
public static void insertBookedRoom(Connection conn, String roomNumber, BigInteger reservationID) throws SQLException {
    String sql = "Insert into Reserved_Rooms(roomNumber, reservationID ) values (?, ?)";
    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setObject(1, roomNumber);
    pstm.setObject(2, reservationID.toString());
    pstm.executeUpdate();
}}

