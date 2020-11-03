public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT JOB_ID, MAX(SALARY), MIN(SALARY)
FROM EMPLOYEES
GROUP BY JOB_ID
HAVING MIN(SALARY) <= ?");
		stmt.setObject(1 , id);
		ResultSet rs = stmt.executeQuery();
	}
}