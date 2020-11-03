public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT JOB_ID, JOB_TITLE FROM JOBS WHERE JOB_TITLE =" + var2;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}