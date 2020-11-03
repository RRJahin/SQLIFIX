public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT NIJE.EMPLOYEE_ID FROM EMPLOYEES NIJE, EMPLOYEES ONNO  WHERE NIJE.SALARY< ONNO.SALARY GROUP BY NIJE.EMPLOYEE_ID HAVING COUNT(*) <?;");
		stmt.setObject(1 , id1);
		ResultSet rs = stmt.executeQuery();
	}
}