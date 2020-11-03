public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT JOB_ID, JOB_TITLE, MIN_SALARY FROM JOBS WHERE JOB_TITLE <=" + var1+" AND MIN_SALARY <" + rand0;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}