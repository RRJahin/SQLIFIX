public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT LAST_NAME, SALARY
FROM EMPLOYEES
WHERE JOB_ID =
(
SELECT JOB_ID
FROM EMPLOYEES
WHERE EMPLOYEE_ID = 141
)
AND SALARY >
(
SELECT SALARY
FROM EMPLOYEES
WHERE EMPLOYEE_ID = "+id"
) ";
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}