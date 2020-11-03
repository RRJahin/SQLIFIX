public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT JOB_ID,SALARY
FROM EMPLOYEES
WHERE SALARY > "+num"
GROUP BY JOB_ID
ORDER BY JOB_ID ASC");
	}
}