public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT EMPLOYEE_ID, MANAGER_ID FROM EMPLOYEES WHERE MANAGER_ID >=" + var1;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}