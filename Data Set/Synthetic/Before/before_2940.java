public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEES WHERE SALARY NOT IN (" + id1 + ", " + id2 + ");");
	}
}