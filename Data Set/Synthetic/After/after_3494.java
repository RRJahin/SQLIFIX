public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT EMPLOYEE_ID, PHONE_NUMBER FROM EMPLOYEES WHERE PHONE_NUMBER >= ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , var2);
		stmt.setObject(2 ,  );
		stmt.executeQuery();
	}
}