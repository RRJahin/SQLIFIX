public class Dummy{
public static void insertBookedRoom(Connection conn, String roomNumber, BigInteger reservationID) throws SQLException {
    String sql = "Insert into Reserved_Rooms(roomNumber, reservationID ) values ("+roomNumber+", "+reservationID.toString()+")";
    Statement pstm = conn.createStatement();
    pstm.executeUpdate(sql);
}}

