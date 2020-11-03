public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT DEPARTMENT_ID, MANAGER_ID, LOCATION_ID FROM DEPARTMENTS WHERE MANAGER_ID <=" + val2+" AND LOCATION_ID <" + rand1;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}