public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT JOB_ID, JOB_TITLE FROM JOBS WHERE JOB_TITLE <>" + var2);
	}
}