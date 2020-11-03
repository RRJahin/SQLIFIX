public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT NIJE.EMPLOYEE_ID FROM EMPLOYEES NIJE WHERE " + id1 + " > (SELECT COUNT(ONNO.EMPLOYEE_ID) FROM EMPLOYEES ONNO WHERE NIJE.SALARY>ONNO.SALARY);");
	}
}