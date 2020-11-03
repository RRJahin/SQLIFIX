public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT EMPLOYEE_ID, EMAIL, PHONE_NUMBER FROM EMPLOYEES WHERE EMAIL >=? AND PHONE_NUMBER >?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , val1);
		stmt.setObject(2 , rand2);
		stmt.executeQuery();
	}
}