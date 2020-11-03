public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "UPDATE students SET gpa=? where id>?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , GPA);
		stmt.setObject(2 , ID );
		stmt.executeUpdate();
	}
}