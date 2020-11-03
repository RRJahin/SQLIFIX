public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "UPDATE students SET gpa="+GPA+" where id<"+ID;
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
	}
}