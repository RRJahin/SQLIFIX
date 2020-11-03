public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEES WHERE MANAGER_ID <> " + id1 + " AND SALARY > " + id2 + ";");
	}
}