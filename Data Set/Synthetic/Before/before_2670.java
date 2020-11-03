public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("DELETE FROM EMPLOYEES
WHERE DEPARTMENT_ID =
(
SELECT DEPARTMENT_ID FROM DEPARTMENTS
WHERE UPPER(DEPARTMENT_NAME) LIKE "+name"
)");
	}
}