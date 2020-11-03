public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT DEPARTMENT_ID, MAX(SALARY) FROM EMPLOYEES GROUP BY DEPARTMENT_ID HAVING DEPARTMENT_ID = ANY  (SELECT DEPARTMENT_ID FROM EMPLOYEES WHERE NOT LAST_NAME LIKE '?%');");
		stmt.setObject(1 , id1);
		ResultSet rs = stmt.executeQuery();
	}
}