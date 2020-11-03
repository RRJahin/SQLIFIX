public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT JOB_ID, MIN_SALARY, MAX_SALARY FROM JOBS WHERE MIN_SALARY =" + val1+" OR MAX_SALARY =" + rand1;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}