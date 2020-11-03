public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "INSERT into goodStudents(id,name) select id,name from students  where gpa= ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , GPA);
		stmt.executeQuery();
	}
}