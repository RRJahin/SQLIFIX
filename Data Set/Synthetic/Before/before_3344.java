public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT JOB_ID, AVG(SALARY)
FROM EMPLOYEES
GROUP BY JOB_ID
HAVING AVG(SALARY) <> "+num"
ORDER BY AVG(SALARY) ASC";
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}