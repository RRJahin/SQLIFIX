public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT DEPARTMENT_ID, MANAGER_ID FROM DEPARTMENTS WHERE MANAGER_ID <=" + val2;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}