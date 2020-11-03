public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT LAST_NAME, JOB_ID, SALARY
FROM EMPLOYEES
WHERE JOB_ID = ?
AND SALARY < ANY
(
SELECT SALARY
FROM EMPLOYEES
WHERE JOB_ID = ?
)");
		stmt.setObject(1 , id1);
		stmt.setObject(2 , id2);
		ResultSet rs = stmt.executeQuery();
	}
}