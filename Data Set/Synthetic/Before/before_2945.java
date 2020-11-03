public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEES WHERE SALARY NOT  BETWEEN " + id1 + " AND " + id2 + " ;");
	}
}