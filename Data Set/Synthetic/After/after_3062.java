public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT NIJE.EMPLOYEE_ID FROM EMPLOYEES NIJE WHERE ? <> (SELECT COUNT(ONNO.EMPLOYEE_ID) FROM EMPLOYEES ONNO WHERE NIJE.SALARY>ONNO.SALARY);");
		stmt.setObject(1 , id1);
		ResultSet rs = stmt.executeQuery();
	}
}