public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT EMPLOYEE_ID, PHONE_NUMBER FROM EMPLOYEES WHERE PHONE_NUMBER <= ?");
		stmt.setObject(1 , var1);
		stmt.setObject(2 ,  );
		ResultSet rs = stmt.executeQuery();
	}
}