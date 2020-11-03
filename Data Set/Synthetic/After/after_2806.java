public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = INSERT INTO DEPARTMENTS VALUES (?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , number);
		stmt.setObject(2 , post);
		stmt.executeUpdate();
	}
}