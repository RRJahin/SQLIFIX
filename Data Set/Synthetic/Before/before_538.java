public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT JOB_ID, MAX_SALARY FROM JOBS WHERE MAX_SALARY >=" + val2);
	}
}