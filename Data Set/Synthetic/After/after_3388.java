public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT JOB_ID, MAX(DISTINCT SALARY), MIN(DISTINCT SALARY),
SUM(DISTINCT SALARY), COUNT(DISTINCT DEPARTMENT_ID)
FROM EMPLOYEES
WHERE DEPARTMENT_ID < ?
GROUP BY JOB_ID
ORDER BY JOB_ID ASC";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , id);
		stmt.executeQuery();
	}
}