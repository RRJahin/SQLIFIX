public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT JOB_ID, JOB_TITLE, MIN_SALARY FROM JOBS WHERE JOB_TITLE =? OR MIN_SALARY =?");
		stmt.setObject(1 , val1);
		stmt.setObject(2 , rand0);
		ResultSet rs = stmt.executeQuery();
	}
}