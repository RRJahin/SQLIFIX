public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("INSERT into goodStudents(id,name) select id,name from students  where gpa= ?");
		stmt.setObject(1 , GPA);
		ResultSet rs = stmt.executeQuery();
	}
}