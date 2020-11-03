public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT DEPARTMENT_ID, MAX(SALARY) FROM EMPLOYEES GROUP BY DEPARTMENT_ID HAVING DEPARTMENT_ID <> ALL  (SELECT DEPARTMENT_ID FROM EMPLOYEES WHERE LAST_NAME LIKE '" + id1 + "%');";
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}