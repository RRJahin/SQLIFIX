public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT EMPLOYEE_ID, EMAIL, PHONE_NUMBER FROM EMPLOYEES WHERE EMAIL <=? AND PHONE_NUMBER <?");
		stmt.setObject(1 , var2);
		stmt.setObject(2 , rand2);
		ResultSet rs = stmt.executeQuery();
	}
}