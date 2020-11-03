public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT JOB_ID, MAX(SALARY), MIN(SALARY)
FROM EMPLOYEES
WHERE DEPARTMENT_ID = ?
GROUP BY JOB_ID
ORDER BY JOB_ID ASC");
		stmt.setObject(1 , id);
		ResultSet rs = stmt.executeQuery();
	}
}