public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT LAST_NAME, JOB_ID, SALARY
FROM EMPLOYEES
WHERE JOB_ID <=?
OR SALARY > ANY
(
SELECT SALARY
FROM EMPLOYEES
WHERE JOB_ID =?
)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , id1);
		stmt.setObject(2 , id2);
		stmt.executeQuery();
	}
}