public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME FROM EMPLOYEES WHERE FIRST_NAME =? OR LAST_NAME =?");
		stmt.setObject(1 , val2);
		stmt.setObject(2 , rand0);
		ResultSet rs = stmt.executeQuery();
	}
}