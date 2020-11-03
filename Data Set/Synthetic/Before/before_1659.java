public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT LAST_NAME, JOB_ID, SALARY
FROM EMPLOYEES
WHERE JOB_ID <= "+id1+"
OR SALARY > ALL
(
SELECT SALARY
FROM EMPLOYEES
WHERE JOB_ID = "+id2"
)";
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}