public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT JOB_ID, MAX(DISTINCT SALARY), MIN(DISTINCT SALARY),
SUM(DISTINCT SALARY), COUNT(DISTINCT DEPARTMENT_ID)
FROM EMPLOYEES
WHERE DEPARTMENT_ID <= ?
GROUP BY JOB_ID
ORDER BY JOB_ID DESC");
		stmt.setObject(1 , id);
		ResultSet rs = stmt.executeQuery();
	}
}