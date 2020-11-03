public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEES WHERE (SALARY   BETWEEN " + id1 + " AND " + id2 + ") AND (SALARY NOT IN (" + id3+ ", " + id4 + " )) ;");
	}
}