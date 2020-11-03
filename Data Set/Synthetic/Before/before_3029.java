public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT DEPARTMENT_ID, MAX(SALARY) FROM EMPLOYEES GROUP BY DEPARTMENT_ID HAVING DEPARTMENT_ID <> ALL  (SELECT DEPARTMENT_ID FROM EMPLOYEES WHERE LAST_NAME LIKE '" + id1 + "%');");
	}
}