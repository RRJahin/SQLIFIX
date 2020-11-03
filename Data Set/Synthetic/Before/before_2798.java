public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("INSERT into goodStudents(id,name) select id,name from students  where gpa= "+GPA);
	}
}