public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeUpdate("UPDATE students SET gpa="+GPA+" where id<"+ID);
	}
}