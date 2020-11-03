public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT JOB_ID, MIN_SALARY, MAX_SALARY FROM JOBS WHERE MIN_SALARY >? AND MAX_SALARY >?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , val2);
		stmt.setObject(2 , rand1);
		stmt.executeQuery();
	}
}