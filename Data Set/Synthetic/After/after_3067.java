public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM EMPLOYEES MANAGER WHERE EXISTS (SELECT * FROM EMPLOYEES CHAKOR WHERE MANAGER.EMPLOYEE_ID = CHAKOR.MANAGER_ID AND LAST_NAME = ?);");
		stmt.setObject(1 , id1);
		ResultSet rs = stmt.executeQuery();
	}
}