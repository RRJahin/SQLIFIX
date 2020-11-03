public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT * FROM EMPLOYEES MANAGER WHERE EXISTS (SELECT * FROM EMPLOYEES CHAKOR WHERE MANAGER.EMPLOYEE_ID = CHAKOR.MANAGER_ID AND LAST_NAME = " +id1 +");";
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}