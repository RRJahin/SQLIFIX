public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT JOB_ID, MAX(SALARY), MIN(SALARY)
FROM EMPLOYEES
GROUP BY JOB_ID
HAVING MAX(SALARY) > ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , id);
		stmt.executeQuery();
	}
}