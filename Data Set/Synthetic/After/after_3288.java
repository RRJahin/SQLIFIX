public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT JOB_ID, AVG(SALARY)
FROM EMPLOYEES
GROUP BY JOB_ID
HAVING AVG(SALARY) >= ?
ORDER BY AVG(SALARY) ASC");
		stmt.setObject(1 , num);
		ResultSet rs = stmt.executeQuery();
	}
}