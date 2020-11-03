public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeUpdate("DELETE FROM DEPARTMENTS
WHERE DEPARTMENT_NAME LIKE"+name);
	}
}