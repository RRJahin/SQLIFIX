public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEES MANAGER WHERE EXISTS (SELECT * FROM EMPLOYEES CHAKOR WHERE MANAGER.EMPLOYEE_ID = CHAKOR.MANAGER_ID AND LAST_NAME <> " +id1 +");");
	}
}