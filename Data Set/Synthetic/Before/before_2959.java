public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT * FROM EMPLOYEES WHERE (SALARY   BETWEEN " + id1 + " AND " + id2 + ") AND (SALARY NOT IN (" + id3+ ", " + id4 + " )) ;";
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}