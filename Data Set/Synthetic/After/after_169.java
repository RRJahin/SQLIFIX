public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT JOB_ID,SALARY
FROM EMPLOYEES
WHERE SALARY <= ?
GROUP BY JOB_ID
ORDER BY JOB_ID DESC";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , num);
		stmt.executeQuery();
	}
}