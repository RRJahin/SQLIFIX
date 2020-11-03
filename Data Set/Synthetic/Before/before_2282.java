public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "DELETE FROM EMPLOYEES
WHERE DEPARTMENT_ID =
(
SELECT DEPARTMENT_ID FROM DEPARTMENTS
WHERE UPPER(DEPARTMENT_NAME) = "+name"
)";
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}