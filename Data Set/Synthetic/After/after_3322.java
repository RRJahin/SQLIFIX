public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT JOB_ID, AVG(SALARY)
FROM EMPLOYEES
GROUP BY JOB_ID
HAVING AVG(SALARY) < ?
ORDER BY AVG(SALARY) ASC";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , num);
		stmt.executeQuery();
	}
}