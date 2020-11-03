public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT JOB_ID, MIN_SALARY FROM JOBS WHERE MIN_SALARY <=" + var1;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}