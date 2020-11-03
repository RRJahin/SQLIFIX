public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT * FROM EMPLOYEES WHERE MANAGER_ID <> " + id1 + " AND SALARY <> " + id2 + ";";
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}