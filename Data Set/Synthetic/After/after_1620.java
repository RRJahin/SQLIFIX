public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT EMPLOYEE_ID, LAST_NAME, EMAIL FROM EMPLOYEES WHERE LAST_NAME >? OR EMAIL >?");
		stmt.setObject(1 , var2);
		stmt.setObject(2 , rand1);
		ResultSet rs = stmt.executeQuery();
	}
}