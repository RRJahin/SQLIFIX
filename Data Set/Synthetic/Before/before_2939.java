public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT * FROM EMPLOYEES WHERE SALARY NOT IN (" + id1 + ", " + id2 + ");";
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}