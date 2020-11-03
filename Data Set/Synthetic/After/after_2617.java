public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT JOB_ID, JOB_TITLE, MIN_SALARY FROM JOBS WHERE JOB_TITLE <=? AND MIN_SALARY <?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , val1);
		stmt.setObject(2 , rand0);
		stmt.executeQuery();
	}
}