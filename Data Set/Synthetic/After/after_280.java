public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT JOB_ID, MAX(SALARY), MIN(SALARY)
FROM EMPLOYEES
WHERE DEPARTMENT_ID >= ?
GROUP BY JOB_ID";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , id);
		stmt.executeQuery();
	}
}