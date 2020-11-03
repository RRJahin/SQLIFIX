public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT JOB_ID,SALARY
FROM EMPLOYEES
WHERE SALARY < "+num"
GROUP BY JOB_ID
ORDER BY JOB_ID ASC";
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}