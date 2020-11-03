public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("UPDATE students SET gpa=? where id=?");
		stmt.setObject(1 , GPA);
		stmt.setObject(2 , ID );
		ResultSet rs = stmt.executeUpdate();
	}
}