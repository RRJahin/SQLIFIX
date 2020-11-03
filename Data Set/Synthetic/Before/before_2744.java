public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT LAST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY >
(
SELECT SALARY
FROM EMPLOYEES
WHERE LAST_NAME = "+name"
) ";
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}