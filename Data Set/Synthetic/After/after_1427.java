public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT DEPARTMENT_ID, MANAGER_ID, LOCATION_ID FROM DEPARTMENTS WHERE MANAGER_ID >? AND LOCATION_ID >?");
		stmt.setObject(1 , val1);
		stmt.setObject(2 , rand1);
		ResultSet rs = stmt.executeQuery();
	}
}