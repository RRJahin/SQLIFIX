public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT JOB_ID,SALARY
FROM EMPLOYEES
WHERE SALARY = ?
GROUP BY JOB_ID
ORDER BY JOB_ID ASC");
		stmt.setObject(1 , num);
		ResultSet rs = stmt.executeQuery();
	}
}