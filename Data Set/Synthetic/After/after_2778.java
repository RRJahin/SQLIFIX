public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT LAST_NAME, SALARY
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
WHERE EMPLOYEE_ID = ?
) ");
		stmt.setObject(1 , id);
		ResultSet rs = stmt.executeQuery();
	}
}