public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT NIJE.EMPLOYEE_ID FROM EMPLOYEES NIJE WHERE ? = (SELECT COUNT(ONNO.EMPLOYEE_ID) FROM EMPLOYEES ONNO WHERE NIJE.SALARY>ONNO.SALARY);";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , id1);
		stmt.executeQuery();
	}
}