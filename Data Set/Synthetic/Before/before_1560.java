public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT LAST_NAME, JOB_ID, SALARY
FROM EMPLOYEES
WHERE JOB_ID < "+id1+"
OR SALARY < ANY
(
SELECT SALARY
FROM EMPLOYEES
WHERE JOB_ID = "+id2"
)");
	}
}