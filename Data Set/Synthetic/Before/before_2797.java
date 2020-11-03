public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "INSERT into goodStudents(id,name) select id,name from students  where gpa= "+GPA;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}