public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT DEPARTMENT_ID, MANAGER_ID FROM DEPARTMENTS WHERE MANAGER_ID >=" + val1);
	}
}