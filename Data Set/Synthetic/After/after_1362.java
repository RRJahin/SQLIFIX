public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID FROM DEPARTMENTS WHERE DEPARTMENT_NAME >=? OR MANAGER_ID >?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , val2);
		stmt.setObject(2 , rand0);
		stmt.executeQuery();
	}
}