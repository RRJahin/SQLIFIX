public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT NIJE.EMPLOYEE_ID FROM EMPLOYEES NIJE, EMPLOYEES ONNO  WHERE NIJE.SALARY< ONNO.SALARY GROUP BY NIJE.EMPLOYEE_ID HAVING COUNT(*) <>" + id1 + ";");
	}
}