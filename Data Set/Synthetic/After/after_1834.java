public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT EMPLOYEE_ID, PHONE_NUMBER, HIRE_DATE FROM EMPLOYEES WHERE PHONE_NUMBER <=? OR HIRE_DATE <?");
		stmt.setObject(1 , var2);
		stmt.setObject(2 , rand3);
		ResultSet rs = stmt.executeQuery();
	}
}