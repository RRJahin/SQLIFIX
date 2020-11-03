public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID FROM DEPARTMENTS WHERE DEPARTMENT_NAME =? OR MANAGER_ID =?");
		stmt.setObject(1 , var1);
		stmt.setObject(2 , rand0);
		ResultSet rs = stmt.executeQuery();
	}
}