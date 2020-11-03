public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT NIJE.EMPLOYEE_ID FROM EMPLOYEES NIJE WHERE " + id1 + " > (SELECT COUNT(ONNO.EMPLOYEE_ID) FROM EMPLOYEES ONNO WHERE NIJE.SALARY>ONNO.SALARY);";
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}