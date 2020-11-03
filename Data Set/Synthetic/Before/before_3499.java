public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT JOB_ID, MAX(DISTINCT SALARY), MIN(DISTINCT SALARY),
SUM(DISTINCT SALARY), COUNT(DISTINCT DEPARTMENT_ID)
FROM EMPLOYEES
WHERE DEPARTMENT_ID >= "+id"
GROUP BY JOB_ID
ORDER BY JOB_ID DESC";
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}