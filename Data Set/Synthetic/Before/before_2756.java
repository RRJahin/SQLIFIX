public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT LAST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY >
(
SELECT SALARY
FROM EMPLOYEES
WHERE LAST_NAME = "+name"
) ");
	}
}