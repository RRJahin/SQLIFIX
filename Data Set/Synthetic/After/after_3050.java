public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT NIJE.EMPLOYEE_ID FROM EMPLOYEES NIJE, EMPLOYEES ONNO  WHERE NIJE.SALARY< ONNO.SALARY GROUP BY NIJE.EMPLOYEE_ID HAVING COUNT(*) =?;";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , id1);
		stmt.executeQuery();
	}
}