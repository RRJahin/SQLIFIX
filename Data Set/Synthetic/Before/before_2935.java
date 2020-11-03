public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT * FROM EMPLOYEES WHERE HIRE_DATE <> '" + id1 + "';";
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}