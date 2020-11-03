public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "DELETE FROM EMPLOYEES WHERE JOB_ID<>"+ID;
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
	}
}