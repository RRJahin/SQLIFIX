public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT JOB_ID, MAX_SALARY FROM JOBS WHERE MAX_SALARY >=" + var1;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}