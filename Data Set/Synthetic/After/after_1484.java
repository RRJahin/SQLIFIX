public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT DEPARTMENT_ID, MANAGER_ID, LOCATION_ID FROM DEPARTMENTS WHERE MANAGER_ID <>? AND LOCATION_ID <?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , val2);
		stmt.setObject(2 , rand1);
		stmt.executeQuery();
	}
}