public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT JOB_ID, MAX(SALARY), MIN(SALARY)
FROM EMPLOYEES
WHERE DEPARTMENT_ID< = "+id"
GROUP BY JOB_ID";
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}