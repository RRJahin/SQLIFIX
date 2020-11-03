public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT JOB_ID, MIN_SALARY, MAX_SALARY FROM JOBS WHERE MIN_SALARY <=? OR MAX_SALARY <?");
		stmt.setObject(1 , val1);
		stmt.setObject(2 , rand1);
		ResultSet rs = stmt.executeQuery();
	}
}