public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT DEPARTMENT_ID, LOCATION_ID FROM DEPARTMENTS WHERE LOCATION_ID <>" + var2;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}