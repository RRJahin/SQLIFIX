public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement(INSERT INTO DEPARTMENTS VALUES (?,?)");
		stmt.setObject(1 , number);
		stmt.setObject(2 , post);
		ResultSet rs = stmt.executeUpdate();
	}
}